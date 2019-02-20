package com.springboot.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author mark-liu
 */
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.mark")
@Component
@Data
public class TestConfig {
    private String name;
    private String age;
}
