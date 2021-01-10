package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "public", name = "genus")
public class Genus {
    private long id;
    private String name;
    private List<Plant> plants;
    public Genus(){
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @OneToMany(mappedBy = "genus", cascade = {CascadeType.ALL})
    public List<Plant> getPlants(){
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Genus genus = (Genus) o;
        return id == genus.id &&
                Objects.equals(name,genus.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
