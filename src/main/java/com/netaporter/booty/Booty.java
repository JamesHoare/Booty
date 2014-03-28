package com.netaporter.booty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jameshoare on 28/03/2014.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Booty {

    public static void main(String[] args) {
        SpringApplication.run(Booty.class,args);

    }

}
