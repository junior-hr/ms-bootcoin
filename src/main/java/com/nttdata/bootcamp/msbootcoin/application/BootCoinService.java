package com.nttdata.bootcamp.msbootcoin.application;

import com.nttdata.bootcamp.msbootcoin.dto.BootCoinDto;
import com.nttdata.bootcamp.msbootcoin.model.BootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class BootCoinService.
 * BootCoin microservice class BootCoinService.
 */
public interface BootCoinService {

    public Flux<BootCoin> findAll();

    public Mono<BootCoin> findById(String idBootCoin);

    public Mono<BootCoinDto> findByCellphone(String cellphone);

    public Mono<BootCoin> save(BootCoinDto bootCoinDto);

    public Mono<BootCoin> update(BootCoinDto bootCoinDto, String idBootCoin);

    public Mono<Void> delete(String idBootCoin);

    public Mono<BootCoin> updateBalanceById(String idBootCoin, Double balance);

    public Flux<BootCoin> findBalanceByDocumentNumber(String documentNumber);

}
