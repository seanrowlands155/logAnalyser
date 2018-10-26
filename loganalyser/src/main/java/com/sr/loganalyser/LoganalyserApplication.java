package com.sr.loganalyser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sr")
public class LoganalyserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoganalyserApplication.class, args);
    }
}
