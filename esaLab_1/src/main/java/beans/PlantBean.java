package beans;

import entities.Plant;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Singleton
public class PlantBean {

    @PersistenceContext(unitName = "esa")
    private EntityManager em;

    public Collection<Plant> findAll(){
        return em.createQuery("SELECT c FROM Plant c", Plant.class).getResultList();
    }
}
