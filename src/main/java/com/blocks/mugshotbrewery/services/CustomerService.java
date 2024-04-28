package com.blocks.mugshotbrewery.services;

import com.blocks.mugshotbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID uuid);
}
