package com.example.storage.domain.type;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Resource
    private TypeRepository typeRepository;


    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

}
