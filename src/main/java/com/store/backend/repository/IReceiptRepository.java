package com.store.backend.repository;

import com.store.backend.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptRepository extends ReactiveMongoRepository<Receipt,String> {
}
