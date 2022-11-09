package com.devrev.assignment.carwash.services;

import com.devrev.assignment.carwash.entity.Places;
import com.devrev.assignment.carwash.repository.CredentialsRepo;
import com.devrev.assignment.carwash.repository.PlacesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesService {
    private final PlacesRepo placesRepo;
    @Autowired
    public PlacesService(PlacesRepo placesRepo){
        this.placesRepo = placesRepo;
    }

    public List<Places> getPlacesByName(String placeName){
        return placesRepo.findAllByPlaceName(placeName);
    }

    public boolean addNewPlace(Places place) {
        if(placesRepo.existsPlacesByPincodeOrPlaceName(place.getPincode(),place.getPlaceName()))
            return false;
        else{
            placesRepo.save(place);
            return true;
        }
    }
    public boolean updatePlace(Places place) {
        if(!placesRepo.existsPlacesByPincode(place.getPincode()))
            return false;
        else{
            placesRepo.save(place);
            return true;
        }
    }
}
