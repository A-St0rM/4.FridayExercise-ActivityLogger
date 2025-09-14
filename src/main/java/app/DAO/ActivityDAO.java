package app.DAO;

import app.DTO.ActivityDTO;
import app.entities.Activity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class ActivityDAO implements IDAO<ActivityDTO>{
    private EntityManagerFactory emf;

    public ActivityDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public List<ActivityDTO> findAll() {
        return List.of();
    }

    @Override
    public ActivityDTO findById(int id) {
        return null;
    }

    @Override
    public ActivityDTO save(ActivityDTO activity) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Activity activity = ActivityMapper
            em.persist(activity);
            em.getTransaction().commit();
            return activity;
        }
        finally {
            emf.close();
        }

    }

    @Override
    public void delete(ActivityDTO activity) {

    }

    @Override
    public void Update(ActivityDTO activity) {

    }

    //You should create a ActivityDAO class that can persist the data in the database.
    // Send in the DTO’s and let the DAO class persist the data. You might want to return DTO’s with the ID’s from the database when creating new entries.



}
