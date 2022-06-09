package com.store.backend.usecases.receipt;

import com.store.backend.dto.ReceiptDTO;
import com.store.backend.mapper.ReceiptMapper;
import com.store.backend.repository.IReceiptRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostReceiptUseCase {
    private final IReceiptRepository iReceiptRepository;
    private final ReceiptMapper receiptMapper;

    public Mono<ReceiptDTO> postReceipt(ReceiptDTO receiptDTO){
        return iReceiptRepository.save(receiptMapper.fromReceiptDTOToReceipt(receiptDTO)).map(receiptMapper::fromReceiptToReceiptDTO);
    }
}
