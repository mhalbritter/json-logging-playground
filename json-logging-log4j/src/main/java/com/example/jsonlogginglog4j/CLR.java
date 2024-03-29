package com.example.jsonlogginglog4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    }
}
