package com.store.backend.mapper;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.collection.Receipt;
import com.store.backend.dto.ProviderDTO;
import com.store.backend.dto.ReceiptDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ReceiptMapper {

    private final ModelMapper modelMapper;

    public ReceiptMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ReceiptDTO fromReceiptToReceiptDTO(Receipt receipt){
        return modelMapper.map(receipt, ReceiptDTO.class);
    }

    public Receipt fromReceiptDTOToReceipt(ReceiptDTO receiptDTO){
        return modelMapper.map(receiptDTO, Receipt.class);
    }

}
