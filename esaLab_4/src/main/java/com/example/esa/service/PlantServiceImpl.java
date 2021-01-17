package com.example.esa.service;


import com.example.esa.model.Plant;
import com.example.esa.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository plantRepository;

    @Override
    public void create(Plant plant) {
        plantRepository.save(plant);
    }

    @Override
    public List<Plant>  readAll() {
        return plantRepository.findAll();
    }

    @Override
    public Plant read(int id) {
        return plantRepository.getOne(id);
    }

    @Override
    public boolean update(Plant plant, int id) {
        if (plantRepository.existsById(id)) {
            plant.setId(id);
            plantRepository.save(plant);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (plantRepository.existsById(id)) {
            plantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}