package com.springboot.example.jpa.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author mark-liu
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String age;
}
