package com.fineuploader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(UploadServerProperties.class)
public class SpringBootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServerApplication.class, args);
    }

}
