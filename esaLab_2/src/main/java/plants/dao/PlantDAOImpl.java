package plants.dao;

import plants.model.Plant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlantDAOImpl implements PlantDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Plant> allPlants(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Plant").list();
    }

    @Override
    public void add(Plant plant) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(plant);
    }

    @Override
    public void delete(Plant plant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(plant);
    }

    @Override
    public void edit(Plant plant) {
        Session session = sessionFactory.getCurrentSession();
        session.update(plant);
    }

    @Override
    public Plant getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Plant.class, id);
    }

    @Override
    public boolean checkName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Plant where name = :name");
        query.setParameter("name", name);
        return query.list().isEmpty();
    }
}
