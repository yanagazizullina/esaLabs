package com.example.esa.controller;

import com.example.esa.model.Plant;
import com.example.esa.repository.PlantRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

@Controller
@RequestMapping("/xml")
public class XmlController {

    private final PlantRepository plantRepository;

    @Autowired
    public XmlController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @ResponseBody
    @GetMapping(path = "/plants", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView getPlants() throws JsonProcessingException {
        Iterable<Plant> list =  plantRepository.findAll();
        return getModelAndView(list, "");
    }

    private ModelAndView getModelAndView(Iterable<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("ArrayList", src);
        return mod;
    }
}
