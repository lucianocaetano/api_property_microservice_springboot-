package com.microservice.server1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.server1.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, String> {

}
