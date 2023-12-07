package com.example.storage.domain.county;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {

    @Resource
    private CountyRepository countyRepository;


    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }
}
