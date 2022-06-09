package com.store.backend.usecases.product;

import com.store.backend.dto.ProductDTO;
import com.store.backend.mapper.ProductMapper;
import com.store.backend.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostProductUseCase {

    private final IProductRepository iProductRepository;
    private final ProductMapper productMapper;

    public Mono<ProductDTO> postProduct(ProductDTO productDTO){
        return iProductRepository.save(productMapper.fromProductDTOToProduct(productDTO)).map(productMapper::fromProductToProductDTO);
    }
}
