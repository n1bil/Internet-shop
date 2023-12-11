package org.demointernetshop.config;

import org.demointernetshop.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CartMapper cartMapper() {
        return new CartMapper();
    }

    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapper();
    }

    @Bean
    public ManufacturerMapper manufacturerMapper() {
        return new ManufacturerMapper();
    }

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

}
