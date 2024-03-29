package com.joaoeduardo.micrometertracing.infra;

import com.joaoeduardo.micrometertracing.model.AddressEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressHttpClient {

    private static final Logger log = LoggerFactory.getLogger(AddressHttpClient.class);
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<AddressEntity> getAddressesByCustomerId(Long customerId) {
        log.info("method=getAddressesByCustomerId, customerId={}", customerId);
        return restTemplateBuilder
                .build()
                .getForEntity("http://localhost:8889/addresses/customers/" + customerId, List.class)
                .getBody();
    }
}
