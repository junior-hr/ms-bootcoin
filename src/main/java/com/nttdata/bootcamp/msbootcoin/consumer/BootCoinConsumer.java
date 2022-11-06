package com.nttdata.bootcamp.msbootcoin.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.nttdata.bootcamp.msbootcoin.application.BootCoinService;
import com.nttdata.bootcamp.msbootcoin.consumer.mapper.BalanceBootCoinModel;
import com.nttdata.bootcamp.msbootcoin.infrastructure.BootCoinRepository;
import com.nttdata.bootcamp.msbootcoin.model.BootCoin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import reactor.core.publisher.Mono;

/**
 * Class BootCoinConsumer.
 * BootCoin microservice class BootCoinConsumer.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class BootCoinConsumer {

    @Autowired
    private BootCoinService bootCoinService;

    @Autowired
    private BootCoinRepository bootCoinRepository;

    @KafkaListener(topics = "${spring.kafka.topic.bootcoin.name}")
    public void listener(@Payload BalanceBootCoinModel balanceModel) {
        log.info("Message received : {} ", balanceModel);
        applyBalance(balanceModel).block();
    }

    private Mono<BootCoin> applyBalance(BalanceBootCoinModel request) {
        log.info("applyBalance executed : {} ", request);
        return bootCoinService.updateBalanceById(
                request.getIdBootCoin(), request.getBalance());
    }
}
