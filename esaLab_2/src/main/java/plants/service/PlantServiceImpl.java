package plants.service;

import plants.dao.PlantDao;
import plants.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService{

    private PlantDao plantDAO;

    @Autowired
    public void setPlantDAO(PlantDao plantDAO) {
        this.plantDAO = plantDAO;
    }

    @Override
    @Transactional
    public List<Plant> allPlants(int page) {
        return plantDAO.allPlants(page);
    }

    @Override
    @Transactional
    public void add(Plant plant) {
        plantDAO.add(plant);
    }

    @Override
    @Transactional
    public void delete(Plant plant) {
        plantDAO.delete(plant);
    }

    @Override
    @Transactional
    public void edit(Plant plant) {
        plantDAO.edit(plant);
    }

    @Override
    @Transactional
    public Plant getById(int id) {
        return plantDAO.getById(id);
    }

    @Override
    @Transactional
    public boolean checkName(String name) {
        return plantDAO.checkName(name);
    }
}
