package com.example.msafeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsaFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaFeignApplication.class, args);
    }

}
