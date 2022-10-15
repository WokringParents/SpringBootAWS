package com.example.awstest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileUploadProperties.class
})

public class Awstest2Application {

    public static void main(String[] args) {
        SpringApplication.run(Awstest2Application.class, args);
    }

}
