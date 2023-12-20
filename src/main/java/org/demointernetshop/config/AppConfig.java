package org.demointernetshop.config;

import org.demointernetshop.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public ProductMapper productMapper(CategoryMapper categoryMapper, ManufacturerMapper manufacturerMapper) {
        return new ProductMapper(categoryMapper, manufacturerMapper);
    }

    @Bean
    public UserMapper userMapper(PasswordEncoder passwordEncoder) {
        return new UserMapper(passwordEncoder);
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

}
