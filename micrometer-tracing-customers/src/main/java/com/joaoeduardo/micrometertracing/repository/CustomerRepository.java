package com.joaoeduardo.micrometertracing.repository;

import com.joaoeduardo.micrometertracing.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
