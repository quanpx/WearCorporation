package com.example.demo.config.product;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("product-md-config")
public class ProductModuleConfig {

    private String team;
}
