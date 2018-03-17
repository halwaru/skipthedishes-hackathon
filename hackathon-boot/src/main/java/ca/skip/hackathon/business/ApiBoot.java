package ca.skip.hackathon.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import ca.skip.hackathon.rest.controller.ControllersPackageInfo;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = ControllersPackageInfo.class)
public class ApiBoot {

    public static void main(String[] args) {
        SpringApplication.run(ApiBoot.class, args);
    }

}
