package com.example.storage.domain.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CountyService {
    @Resource
    private CountyRepository countyRepository;

    public County getCountyBy(Integer countyId) {
        return countyRepository.getReferenceById(countyId);
    }
}
