package com.blocks.mugshotbrewery.web.controller;

import com.blocks.mugshotbrewery.services.BeerService;
import com.blocks.mugshotbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postBeer(@RequestBody BeerDto beerDto) {

        BeerDto savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // todo: add hostname to the URI
        headers.add("location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId") UUID beerId ,@RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
    }
  
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }
}

