package com.nttdata.banco.controller;

import com.nttdata.banco.model.Client;
import com.nttdata.banco.service.IclientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class ClientControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private IclientService clientService;

    @Test
    void register() {
        Client client = new Client("638a5d6e5968997b3866f064", "JD 4", "email4@gmail.com", "987654321" , "12345678", "person");
        webTestClient.post()
                .uri("/client")
                .body(Mono.just(client), Client.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Client.class)
                .consumeWith( response ->{
                    Client cl = response.getResponseBody();
                    Assertions.assertThat(cl.getName().equals("JD 4")).isTrue();
                });
    }

    @Test
    void findAll() {
        webTestClient.get()
                .uri("/client")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Client.class)
                .consumeWith(response ->{
                    Flux<Client> clients = Flux.fromIterable(response.getResponseBody());
                    Assertions.assertThat(clients.hasElements());
                });
    }

    @Test
    void findById() {
        Client client = clientService.findById("638a5d6e5968997b3866f064").block();
        webTestClient.get()
                .uri("/client/{id}", Collections.singletonMap("id", client.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Client.class)
                .consumeWith( response ->{
                    Mono<Client> cl = Mono.just(response.getResponseBody());
                    Assertions.assertThat(client.getName()).isEqualTo("JD 4");
                });
    }

    @Test
    void modify() {
        Client client = clientService.findById("638a5d6e5968997b3866f064").block();
        client.setDocument("12345670");
        webTestClient.put()
                .uri("/client")
                .body(Mono.just(client), Client.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Client.class)
                .consumeWith( response ->{
                    Client cl = response.getResponseBody();
                    Assertions.assertThat(cl.getName().equals("JD 4")).isTrue();
                    Assertions.assertThat(cl.getDocument().equals("12345670")).isTrue();
                });
    }

    @Test
    void delete() {
        Client client = clientService.findById("638a5d6e5968997b3866f064").block();

        webTestClient.delete()
                .uri("/client/{id}", Collections.singletonMap("id",client.getId()))
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }
}