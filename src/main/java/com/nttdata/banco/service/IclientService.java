package com.nttdata.banco.service;

import com.nttdata.banco.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client service interface.
 */
public interface IclientService {

    public Flux<Client> findAll();

    public Mono<Client> register(Client client);

    public Mono<Client> update(Client client);

    public Mono<Void> delete(String id);

    public Mono<Client> findById(String id);

}
