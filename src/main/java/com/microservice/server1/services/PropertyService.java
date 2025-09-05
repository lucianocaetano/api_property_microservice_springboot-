package com.microservice.server1.services;

import java.util.List;

import com.microservice.server1.model.Property;

public interface PropertyService {
   
    public Property save(Property property);
    public void delete(String id);
    public List<Property> findAll();
}
