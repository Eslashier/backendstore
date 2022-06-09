package com.store.backend.usecases.bill;

import com.store.backend.dto.BillDTO;
import com.store.backend.mapper.BillMapper;
import com.store.backend.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetBillUsesCase {
    private final IBillRepository iBillRepository;
    private final BillMapper billMapper;

    public Flux<BillDTO> getAllBills(){
        return iBillRepository.findAll().map(billMapper::fromBillToBillDTO);
    }
}
