package com.tubm.webapp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private Boolean available;
    private Integer quantity;

    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;
}
