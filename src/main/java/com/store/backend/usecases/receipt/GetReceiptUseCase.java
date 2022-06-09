package com.store.backend.usecases.receipt;

import com.store.backend.dto.BillDTO;
import com.store.backend.dto.ReceiptDTO;
import com.store.backend.mapper.ReceiptMapper;
import com.store.backend.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetReceiptUseCase {
    private final IReceiptRepository iReceiptRepository;
    private final ReceiptMapper receiptMapper;

    public Flux<ReceiptDTO> getAllReceipts(){
        return iReceiptRepository.findAll().map(receiptMapper::fromReceiptToReceiptDTO);
    }
}
