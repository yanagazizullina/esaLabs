package com.example.esa.service;

import com.example.esa.model.Plant;

import java.util.List;


public interface PlantService {
    void create(Plant plant);

    List<Plant> readAll();

    Plant read(int id);

    boolean update(Plant plant, int id);

    boolean delete(int id);
}
