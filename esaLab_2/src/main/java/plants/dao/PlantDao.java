package plants.dao;


import plants.model.Plant;

import java.util.List;

public interface PlantDao {
    List<Plant> allPlants(int page);
    void add(Plant plant);
    void delete(Plant plant);
    void edit(Plant plant);
    Plant getById(int id);
    boolean checkName(String name);
}
