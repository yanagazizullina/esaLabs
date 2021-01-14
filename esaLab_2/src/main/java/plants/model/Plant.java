package plants.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Column(name = "genus")
    public String getGenus(){
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    @Column(name = "lighting")
    public  String getLighting(){
        return lighting;
    }

    public void setLighting(String lighting){
        this.lighting = lighting;
    }

    @Column(name = "watering")
    public String getWatering(){
        return watering;
    }

    public void setWatering(String watering){
        this.watering = watering;
    }

    @Column(name = "temperature")
    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

}
