package com.devrev.assignment.carwash.controller;

import com.devrev.assignment.carwash.entity.Places;
import com.devrev.assignment.carwash.services.CredentialsService;
import com.devrev.assignment.carwash.services.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "carwash/")
public class PlacesController {
    @Autowired
    public final PlacesService placesService;

    PlacesController(PlacesService placesService){
        this.placesService = placesService;
    }

    @PostMapping("/admin/add/place")
    ResponseEntity<String> addNewPlace(@RequestBody Places place){
        if(placesService.addNewPlace(place))
            return new ResponseEntity<>("Successfully Added New Place", HttpStatus.ACCEPTED);
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not Updated");
    }

    @PostMapping("/admin/update/place")
    ResponseEntity<String> updatePlace(@RequestBody Places place){
        if(placesService.updatePlace(place))
            return new ResponseEntity<>("Successfully Added Updated Place", HttpStatus.ACCEPTED);
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Place Doesn't Exist");
    }

    @GetMapping("/user/search/place/{placeName}")
    ResponseEntity<List<Places>> getAllPlacesByName(@PathVariable("placeName") String placeName){
        return new ResponseEntity<>(placesService.getPlacesByName(placeName),HttpStatus.OK);
    }
}
