package com.store.backend.repository;

import com.store.backend.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends ReactiveMongoRepository<Bill,String> {
}
