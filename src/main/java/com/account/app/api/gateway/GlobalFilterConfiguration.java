package com.account.app.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {
    private final Logger LOGGER = LoggerFactory.getLogger(GlobalFilterConfiguration.class);

    @Bean
    @Order(2)
    public GlobalFilter secondGlobalFilter() {
        return ((exchange, chain) -> {
            LOGGER.info("My second pre-filter executed. ");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                LOGGER.info("My second post-filter executed. ");
            }));
        });
    }

    @Order(3)
    @Bean
    public GlobalFilter thirdGlobalFilter() {
        return ((exchange, chain) -> {
            LOGGER.info("My third pre-filter executed. ");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                LOGGER.info("My third post-filter executed. ");
            }));
        });
    }

    @Order(4)
    @Bean
    public GlobalFilter fourthGlobalFilter() {
        return ((exchange, chain) -> {
            LOGGER.info("My fourth pre-filter executed. ");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                LOGGER.info("My fourth post-filter executed. ");
            }));
        });
    }
}
