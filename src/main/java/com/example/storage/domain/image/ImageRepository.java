package com.example.storage.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.storage.id = ?1")
    Image findByStorageId(Integer id);

}
