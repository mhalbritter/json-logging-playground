package com.example.jsonloggingecs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLR implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CLR.class);

    @Override
    public void run(String... args) {
        LOGGER.info("Run run run");
        LOGGER.error("Boom", new RuntimeException());
        LOGGER.atInfo().addKeyValue("key", "value").log("Key Value Pairs");
        try (MDC.MDCCloseable ignore = MDC.putCloseable("key", "value")) {
            LOGGER.atInfo().log("MDC");
        }
    }
}
