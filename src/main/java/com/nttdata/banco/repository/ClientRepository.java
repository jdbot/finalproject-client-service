package com.nttdata.banco.repository;

import com.nttdata.banco.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Client Repository.
 */
@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}
