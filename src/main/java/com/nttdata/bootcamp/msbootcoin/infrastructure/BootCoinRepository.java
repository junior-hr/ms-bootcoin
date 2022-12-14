package com.nttdata.bootcamp.msbootcoin.infrastructure;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.nttdata.bootcamp.msbootcoin.dto.BootCoinDto;
import com.nttdata.bootcamp.msbootcoin.model.BootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class BootCoinRepository.
 * BootCoin microservice class BootCoinRepository.
 */
@Repository
public interface BootCoinRepository extends
        ReactiveMongoRepository<BootCoin, String> {

    @Query(value = "{'client.cellphone' : ?0 }")
    Flux<BootCoinDto> findAllByCellphone(String cellphone);

    @Query(value = "{'client.documentNumber' : ?0 }")
    Mono<BootCoinDto> findByDocumentNumber(String cellphone);
}
