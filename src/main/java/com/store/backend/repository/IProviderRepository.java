package com.store.backend.repository;

import com.store.backend.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderRepository extends ReactiveMongoRepository<Provider,String> {
}

