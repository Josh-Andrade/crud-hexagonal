package com.estudo.hexagonal.adapters.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${database.driver}")
    private String driver;

    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(url);
        builder.username(username);
        builder.password(password);
        builder.driverClassName(driver);
        return builder.build();
    }
}
