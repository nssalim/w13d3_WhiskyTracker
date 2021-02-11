package com.example.codeclan.whisky_tracker.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {

    List<Distillery> findByWhiskiesAge(int age);
    List<Distillery> findByRegion(String region);


}
