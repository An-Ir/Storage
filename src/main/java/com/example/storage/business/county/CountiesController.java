package com.example.storage.business.county;

import com.example.storage.business.county.dto.CountyInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountiesController {

    @Resource
    private CountiesService countiesService;

    @GetMapping("/location/counties")
    @Operation(summary = "Tagastab maakondade loetelu.")
    public List<CountyInfo> getCounties() {
        return countiesService.getCounties();
    }
}
