package com.example.esa.controller;

import com.example.esa.JMS.JmsSender;
import com.example.esa.model.BasicModel;
import com.example.esa.model.Email;
import com.example.esa.model.Plant;
import com.example.esa.repository.PlantRepository;
import com.example.esa.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
public class PlantController {
    private final PlantService plantService;
    private final JmsSender jmsSender;

    @Autowired
    public PlantController(PlantService plantService, JmsSender jmsSender) {
        this.plantService = plantService;
        this.jmsSender = jmsSender;
    }

    @Autowired
    PlantRepository plantRepository;

    @PostMapping(value = "/plants")
    public ResponseEntity<?> create(@RequestBody Plant plant) {

        Plant newPlant = new Plant();
        jmsSender.sendObjectUpdate((BasicModel) newPlant, "add");
        String body = "Plant " + newPlant + " was added";
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
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
        Plant plant = this.plantRepository.findById(id).orElse(null);
        jmsSender.sendObjectUpdate((BasicModel) plant, "delete");
        String body = "The plant " + plant + " was deleted";
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        final boolean deleted = plantService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
