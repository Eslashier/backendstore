package com.store.backend.usecases.product;

import com.store.backend.dto.ProductDTO;
import com.store.backend.mapper.ProductMapper;
import com.store.backend.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProductUseCase {

    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public Flux<ProductDTO> getAllProducts(){
        return iProductRepository.findAll().map(productMapper::fromProductToProductDTO);
    }

}
