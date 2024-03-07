package com.joaoeduardo.micrometertracing.service;

import com.joaoeduardo.micrometertracing.infra.AddressHttpClient;
import com.joaoeduardo.micrometertracing.model.AddressEntity;
import com.joaoeduardo.micrometertracing.model.CustomerEntity;
import com.joaoeduardo.micrometertracing.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    private final AddressHttpClient addressHttpClient;

    public CustomerService(CustomerRepository customerRepository, AddressHttpClient addressHttpClient) {

        this.customerRepository = customerRepository;

        this.addressHttpClient = addressHttpClient;
    }

    public CustomerEntity getById(Long id) {
        log.info("method=getById, id={}", id);
        CustomerEntity customerEntity = customerRepository.getReferenceById(id);
        List<AddressEntity> addresses = addressHttpClient.getAddressesByCustomerId(customerEntity.getId());
        log.info("method=getById, id={}, addresses={}", id, addresses);
        customerEntity.setAddresses(addresses);
        return customerEntity;
    }

    public CustomerEntity create(CustomerEntity customerEntity) {
        log.info("method=create, customerEntity={}", customerEntity);
        return customerRepository.save(customerEntity);
    }
}
