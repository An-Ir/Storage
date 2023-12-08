package com.example.storage.domain.location;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
