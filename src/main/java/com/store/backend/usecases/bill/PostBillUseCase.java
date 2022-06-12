package com.store.backend.usecases.bill;

import com.store.backend.dto.BillDTO;
import com.store.backend.mapper.BillMapper;
import com.store.backend.repository.IBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostBillUseCase {
    private final IBillRepository iBillRepository;
    private final BillMapper billMapper;


    public Mono<BillDTO> postBill(BillDTO billDTO){
        return iBillRepository.save(billMapper.fromBillDTOToBill(billDTO)).map(billMapper::fromBillToBillDTO);
    }
}
