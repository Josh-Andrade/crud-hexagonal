package com.estudo.hexagonal.adapters.configuration;

import com.estudo.hexagonal.HexagonalApplication;
import com.estudo.hexagonal.application.ports.UsuarioRepositoryPort;
import com.estudo.hexagonal.application.services.UsuarioServiceImpl;
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
}
