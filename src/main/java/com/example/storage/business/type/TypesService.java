package com.example.storage.business.type;
import com.example.storage.business.type.dto.TypeInfo;
import com.example.storage.domain.type.Type;
import com.example.storage.domain.type.TypeMapper;
import com.example.storage.domain.type.TypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypesService {

    @Resource
    private TypeService typeService;

    @Resource
    private TypeMapper typeMapper;

    public List<TypeInfo> getTypes() {
        List<Type> allTypes = typeService.getAllTypes();
        return typeMapper.toTypeInfos(allTypes);
    }
}
