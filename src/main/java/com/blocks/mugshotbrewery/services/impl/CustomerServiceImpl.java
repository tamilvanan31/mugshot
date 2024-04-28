package com.blocks.mugshotbrewery.services.impl;
import java.util.UUID;

import com.blocks.mugshotbrewery.services.CustomerService;
import com.blocks.mugshotbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID uuid) {
        return CustomerDto
                .builder()
                .id(uuid)
                .customerName("Billy")
                .build();
    }
}
