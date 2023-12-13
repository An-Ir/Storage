package com.example.storage.domain.location;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select l from Location l where l.latitude = ?1 and l.longitude = ?2")
    Optional<Location> findLocationByLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude);
    }
