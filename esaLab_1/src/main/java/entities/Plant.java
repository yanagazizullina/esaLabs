package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "plant")
public class Plant {
    private int id;
    private String name;
    private String lighting;
    private String watering;
    private int temperature;
    private Genus genus;
    public Plant(){
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Column(name = "lighting", nullable = false)
    public  String getLighting(){
        return lighting;
    }

    public void setLighting(String lighting){
        this.lighting = lighting;
    }

    @Column(name = "watering", nullable = false)
    public String getWatering(){
        return watering;
    }

    public void setWatering(String watering){
        this.watering = watering;
    }

    @Column(name = "temperature", nullable = false)
    public int getTemperature(){
        return temperature;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "genus_id")
    public Genus getGenus(){
        return genus;
    }

    public void setGenus(Genus genus){
        this.genus = genus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Plant plant = (Plant) o;
        return id == plant.id &&
                Objects.equals(lighting, plant.lighting) &&
                Objects.equals(watering, plant.watering) &&
                Objects.equals(temperature, plant.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lighting, watering, temperature);
    }

}
