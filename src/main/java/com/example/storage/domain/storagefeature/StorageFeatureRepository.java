package com.example.storage.domain.storagefeature;

import com.example.storage.domain.storage.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StorageFeatureRepository extends JpaRepository<StorageFeature, Integer> {

    @Query("SELECT sf.storage FROM StorageFeature sf where sf.feature.id IN :featureIds AND " +
            "(sf.storage.location.county.id = :countyId or :countyId = 0) " +
            "GROUP BY sf.storage HAVING COUNT(DISTINCT sf.feature.id) = :numFeatures")
    List<Storage> findStoragesByFeatureIds(Integer countyId, List<Integer> featureIds, int numFeatures);

    @Transactional
    @Modifying
    @Query("delete from StorageFeature s where s.storage = ?1")
    int deleteBy(Storage storage);


    @Query("select s from StorageFeature s where s.storage.id = ?1")
    List<StorageFeature> findStorageFeaturesBy(Integer storageId);

    @Query("select s.feature.id from StorageFeature s where s.storage.id = ?1")
    List<Integer> findStorageFeaturesIdsBy(Integer storageId);

}