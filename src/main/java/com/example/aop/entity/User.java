package com.example.aop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {

    @Id
    private Integer id;
    private String name;
    private String email;

}
