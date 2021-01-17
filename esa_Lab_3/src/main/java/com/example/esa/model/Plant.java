package com.example.esa.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "plant")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(schema = "public",name = "plant")
public class Plant implements Serializable {
    private int id;
    private String name;
    private String genus;
    private String lighting;
    private String watering;
    private int temperature;


    @Id
    @Column(name = "id")
    @XmlElement
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    @Column(name = "name")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @XmlElement
    @Column(name = "genus")
    public String getGenus(){
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @XmlElement
    @Column(name = "lighting")
    public  String getLighting(){
        return lighting;
    }

    public void setLighting(String lighting){
        this.lighting = lighting;
    }

    @XmlElement
    @Column(name = "watering")
    public String getWatering(){
        return watering;
    }

    public void setWatering(String watering){
        this.watering = watering;
    }

    @XmlElement
    @Column(name = "temperature")
    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public Plant(){

    }

}
