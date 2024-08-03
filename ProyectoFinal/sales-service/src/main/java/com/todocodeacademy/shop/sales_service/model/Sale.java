package com.todocodeacademy.shop.sales_service.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.REMOVE)
    private List<SaleItem> items;

    @Column(length = 64, nullable = false)
    private String firstName;

    @Column(length = 64, nullable = false)
    private String lastName;

    @Column(length = 64, nullable = false)
    private String country;

    @Column(length = 64, nullable = false)
    private String city;

    @Column(length = 10, nullable = false)
    private String postalCode;

    @Column(length = 256, nullable = false)
    private String addressLine1;

    @Column(length = 256, nullable = false)
    private String addressLine2;

    @Column(length = 256, nullable = false)
    private String contactEmail;

    @Column(length = 20, nullable = false)
    private String contactPhone;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Madrid")
    private Date createdAt;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Madrid")
    private Date updatedAt;
}
