package com.devrev.assignment.carwash.repository;

import com.devrev.assignment.carwash.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacesRepo extends JpaRepository<Places,Long> {
    List<Places> findAllByPlaceName(String placeName);

    Boolean existsPlacesByPincodeOrPlaceName(Long pincode,String placeName);

    boolean existsPlacesByPincode(Long pincode);
}
