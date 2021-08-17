package com.frknuzn.phones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@RefreshScope
@SpringBootApplication
@EnableJpaAuditing
public class PhonesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhonesApplication.class, args);
    }

}
