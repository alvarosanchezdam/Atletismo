package com.alvaro;


import com.alvaro.Service.AtletismoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
        basePackageClasses = { AtletismoApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
public class AtletismoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context=SpringApplication.run(AtletismoApplication.class, args);
        AtletismoService atletismoService=context.getBean(AtletismoService.class);
        atletismoService.testAtletismo();

    }
}