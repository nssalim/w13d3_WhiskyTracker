package com.example.codeclan.whisky_tracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(required = false, name = "whiskyAge") Integer age) {

        // Get all distilleries
        return new ResponseEntity(distilleryRepository.findAll(), HttpStatus.OK);
        // Get all distilleries for a particular region
        if (region != null) {

        // Get all distilleries for a particular region eg Highland
            return new ResponseEntity(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }

        // Get distilleries that have whiskies that are 12 years old
        if (age != null) {
            return new ResponseEntity(distilleryRepository.findByWhiskiesAge(age), HttpStatus.OK);
        }
    }
}

