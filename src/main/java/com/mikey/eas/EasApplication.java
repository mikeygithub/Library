package com.mikey.eas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages={"com.mikey.eas.Mapper"})
@SpringBootApplication
public class EasApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasApplication.class, args);
    }
}
