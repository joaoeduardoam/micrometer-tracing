package com.joaoeduardo.micrometertracing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate bornAt;
    @Transient
    private List<AddressEntity> addresses;
}
