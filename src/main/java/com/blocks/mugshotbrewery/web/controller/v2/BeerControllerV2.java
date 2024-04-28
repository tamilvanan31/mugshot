package com.blocks.mugshotbrewery.web.controller.v2;

import com.blocks.mugshotbrewery.services.v2.BeerServiceV2;
import com.blocks.mugshotbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {
    
    private final BeerServiceV2 beerServiceV2;;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServiceV2 = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity postBeer(@RequestBody BeerDtoV2 beerDto) {

        BeerDtoV2 savedDto = beerServiceV2.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        // todo: add hostname to the URI
        headers.add("location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId") UUID beerId ,@RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);
    }
  
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteBeer(beerId);
    }

}
