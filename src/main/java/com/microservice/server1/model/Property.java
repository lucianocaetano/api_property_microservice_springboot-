package com.microservice.server1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Table(name = "property")
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @NotNull
    @Column(name = "address", length = 150, nullable = false)
    private String address;

    @NotNull
    @Column(name = "image", length = 1200, nullable = false)
    private String image;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_at", nullable = false, updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();
}
