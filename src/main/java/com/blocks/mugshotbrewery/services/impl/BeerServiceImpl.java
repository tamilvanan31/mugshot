package com.blocks.mugshotbrewery.services.impl;

import com.blocks.mugshotbrewery.services.BeerService;
import com.blocks.mugshotbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        // todo: implement update beer method
    }
  
    @Override 
    public void deleteBeer(UUID beerId) {
        // todo: implement deleted method
    }
}
