package com.hongchan.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootjpaApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootjpaApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

}
