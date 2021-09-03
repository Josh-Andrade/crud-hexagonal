package com.estudo.hexagonal.adapters.configuration;

import com.estudo.hexagonal.HexagonalApplication;
import com.estudo.hexagonal.ports.UsuarioRepositoryPort;
import com.estudo.hexagonal.services.KafkaConsumerImpl;
import com.estudo.hexagonal.services.UsuarioServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = HexagonalApplication.class)
public class BeanConfiguration {

    @Bean
    UsuarioServiceImpl usuarioServiceImpl(UsuarioRepositoryPort repository, ModelMapper modelMapper){
        return new UsuarioServiceImpl(repository, modelMapper);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    KafkaConsumerImpl kafkaConsumer(UsuarioRepositoryPort repository, ModelMapper modelMapper){
        return new KafkaConsumerImpl(repository, modelMapper);
    }
}
