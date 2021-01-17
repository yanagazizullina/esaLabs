package com.example.esa.controller;

import com.example.esa.model.Plant;
import com.example.esa.repository.PlantRepository;
import com.example.esa.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @Autowired
    PlantRepository plantRepository;

    @PostMapping(value = "/plants")
    public ResponseEntity<?> create(@RequestBody Plant plant) {
        plantService.create(plant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/plants")
    public ResponseEntity<List<Plant>> read() {
        final List<Plant> plants = plantService.readAll();

        return plants != null &&  !plants.isEmpty()
                ? new ResponseEntity<>(plants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/plants/{id}")
    public ResponseEntity<Plant> read(@PathVariable(name = "id") int id) {
        final Plant plant = plantService.read(id);

        return plant != null
                ? new ResponseEntity<>(plant, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/plants/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Plant plant) {
        final boolean updated = plantService.update(plant, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/plants/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = plantService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }




}
