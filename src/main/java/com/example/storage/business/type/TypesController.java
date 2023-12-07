package com.example.storage.business.type;
import com.example.storage.business.county.CountiesService;
import com.example.storage.business.type.dto.TypeInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TypesController {
    @Resource
    private TypesService typesService;

    @GetMapping("storage/types")
    @Operation(summary = "Tagastab kõik laotüübid")
    public List<TypeInfo> getTypes() {return typesService.getTypes();}
}
