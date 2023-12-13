package com.example.storage.domain.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public Optional<Location> getLocationBy(BigDecimal latitude, BigDecimal longitude) {
       return locationRepository.findLocationByLatitudeAndLongitude(latitude, longitude);
    }
}
