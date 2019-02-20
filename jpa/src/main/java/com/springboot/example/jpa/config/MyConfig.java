package com.springboot.example.jpa.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author mark-liu
 */
@ConfigurationProperties("my")
@Component
@Data
public class MyConfig {
    private String name;

    private Integer age;

    private String uuid;

    private Integer number;
}
