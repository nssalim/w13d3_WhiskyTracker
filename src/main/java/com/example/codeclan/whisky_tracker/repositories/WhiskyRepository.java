package com.example.codeclan.whisky_tracker.repositories;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskiesByYear(int year);
    List<Whisky> findByDistillery(String distillery);
    List<Whisky> findByDistilleryRegion(String region);
    List<Whisky> findByDistilleryNameAndAge(String distillery, int age);

}