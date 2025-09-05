package com.microservice.server1.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.server1.model.Property;
import com.microservice.server1.repositories.PropertyRepository;
import com.microservice.server1.services.PropertyService;

@Service
public class ImplPropertyService implements PropertyService {

    private final PropertyRepository propertyRepository;

    public ImplPropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public void delete(String id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> findAll() {
        return propertyRepository.findAll();
    }
}
