package com.backend.springboot.app.proyecto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EntityScan({"com.backend.springboot.app.commons.proyecto.models.entity"})
public class AyllusinchiServicioProyectoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyllusinchiServicioProyectoApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
