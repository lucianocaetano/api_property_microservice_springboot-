package com.microservice.server1.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.server1.services.PropertyService;


import com.microservice.server1.model.Property;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private final PropertyService propertyService;
    
    public PropertyController(
      PropertyService propertyService
    ) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<?> getProperties() {
        List<Property> properties = propertyService.findAll();

        return ResponseEntity.ok(properties);
    }

    @PostMapping
    public ResponseEntity<?> createProperty(@RequestBody Property property) {
        Property newProperty = propertyService.save(property);

        return ResponseEntity.ok(newProperty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        
        propertyService.delete(id);

        return ResponseEntity.ok(null);
    }
}
