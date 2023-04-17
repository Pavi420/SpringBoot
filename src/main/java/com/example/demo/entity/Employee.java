package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empNo", nullable = false)
    private String empNo;

    @Column(name = "empName")
    private String empName;

    @Column(name = "mobile")
    private String mob;

    @Column(name = "email")
    private String email;

}
