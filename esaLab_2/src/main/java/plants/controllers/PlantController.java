package plants.controllers;

import org.springframework.web.bind.annotation.*;
import plants.service.PlantService;
import plants.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PlantController {
   private int page;

    private PlantService plantService;

    @Autowired
    public void setPlantService(PlantService plantService) {
        this.plantService = plantService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allPlants(@RequestParam(defaultValue = "1") int page) {
        List<Plant> plants = plantService.allPlants(page);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("plants");
        modelAndView.addObject("page", page);
        modelAndView.addObject("plantsList", plants);
        this.page = page;
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage(@ModelAttribute("message") String message) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPlant(@ModelAttribute("plant") Plant plant) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        plantService.add(plant);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id,
                                 @ModelAttribute("message") String message) {
        Plant plant = plantService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("plant", plant);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editPlant(@ModelAttribute("plant") Plant plant) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        plantService.edit(plant);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deletePlant(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        modelAndView.addObject("page", page);
        Plant plant = plantService.getById(id);
        plantService.delete(plant);
        return modelAndView;
    }
}
