package com.nttdata.banco.service.implementation;

import com.nttdata.banco.model.Client;
import com.nttdata.banco.repository.ClientRepository;
import com.nttdata.banco.service.IclientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Client service implementation.
 */
@Service
public class ClientServiceImpl implements IclientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> register(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Void> delete(String id) {
        return clientRepository.deleteById(id);
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }
}
