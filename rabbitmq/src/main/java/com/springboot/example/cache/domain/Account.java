package com.springboot.example.cache.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mark-liu
 */
@Data
public class Account implements Serializable {
    private Long id;
    private String name;
    private String money;
}
