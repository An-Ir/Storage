package com.example.storage.business.county;

import com.example.storage.business.county.dto.CountyInfo;
import com.example.storage.domain.county.County;
import com.example.storage.domain.county.CountyMapper;
import com.example.storage.domain.county.CountyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountiesService {

    @Resource
    private CountyService countyService;

    @Resource
    private CountyMapper countyMapper;


    public List<CountyInfo> getCounties() {
        List<County> allCounties = countyService.getAllCounties();
        return countyMapper.toCountyInfos(allCounties);
    }
}
