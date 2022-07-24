package com.java.moviereviewsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieReviewSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieReviewSiteApplication.class, args);
    }

}
