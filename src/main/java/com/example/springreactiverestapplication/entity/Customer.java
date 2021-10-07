package com.example.springreactiverestapplication.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
public class Customer {
    @Id
     private Integer id;
    @Column
    private String name;
    @Column
    private String address;


}
