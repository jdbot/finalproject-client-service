package com.nttdata.banco.controller;

import com.nttdata.banco.model.Client;
import com.nttdata.banco.service.IclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controller of Client.
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private IclientService clientService;

    //Method to get all the clients
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Client> findAll() {
        return clientService.findAll();
    }

    //Method to insert a new client
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Client> register(@RequestBody Client client) {
        return  clientService.register(client);
    }

    //Method to update a client
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Client> modify(@RequestBody Client client) {
        return  clientService.update(client);
    }

    //Method to get a client by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Client> findById(@PathVariable("id") String id) {
        return clientService.findById(id);
    }

    //Method to delete a client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") String id) {
        return clientService.delete(id);
    }
}
