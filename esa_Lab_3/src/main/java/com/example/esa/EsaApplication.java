package com.example.esa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.example.esa.service"})
public class EsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsaApplication.class, args);
    }

}
