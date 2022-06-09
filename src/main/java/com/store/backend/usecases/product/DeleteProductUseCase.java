package com.store.backend.usecases.product;

import com.store.backend.mapper.ProductMapper;
import com.store.backend.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProductUseCase {
    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public Mono<Void> deleteProductById(String id){
        return iProductRepository.deleteById(id);
    }
}
