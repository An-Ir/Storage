package com.example.storage.domain.storagefeature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StorageFeatureRepository extends JpaRepository<StorageFeature, Integer> {
    @Query("SELECT sf FROM StorageFeature sf " +
            "WHERE sf.storage.location.county.id = ?1 " +
            "AND sf.feature.id IN ?2 " +
            "GROUP BY sf " +
            "HAVING COUNT(DISTINCT sf.feature) = ?3")
    List<StorageFeature> findByCountyAndFeatureIds(Integer countyId, Integer[] featureIds, Long numFeatures);

    @Query("SELECT sf FROM StorageFeature sf " +
            "WHERE sf.storage.id IN (" +
            "SELECT sf2.storage.id FROM StorageFeature sf2 " +
            "WHERE sf2.feature.id IN ?1 " +
            "GROUP BY sf2.storage.id " +
            "HAVING COUNT(DISTINCT sf2.feature.id) = ?2" +
            ")")
    List<StorageFeature> findStoragesByFeatureIds(Integer[] featureIds, Long numFeatures);



}