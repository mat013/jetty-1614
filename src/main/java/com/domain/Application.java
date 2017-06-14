package com.domain;

import com.domain.config.ApplicationConfig;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
@Import({ApplicationConfig.class})
public class Application {
    private static final Logger logger = getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("done");
    }
}