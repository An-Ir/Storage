package com.example.storage.domain.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountyService {
    @Resource
    private CountyRepository countyRepository;

    public County getCountyBy(Integer countyId) {
        return countyRepository.getReferenceById(countyId);
    }

    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }
}
