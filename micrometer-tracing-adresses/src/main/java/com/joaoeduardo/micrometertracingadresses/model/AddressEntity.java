package com.joaoeduardo.micrometertracingadresses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private Long customerId;

}
