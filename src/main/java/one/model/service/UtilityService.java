package one.model.service;


import one.model.entity.Utility;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;


public class UtilityService {

    public EntityManager em = Persistence.createEntityManagerFactory("UTILITIES").createEntityManager();


    public Utility addUtility(Utility utility){
        em.getTransaction().begin();
        Utility utilityFromDB = em.merge(utility);
        em.getTransaction().commit();
        return utilityFromDB;
    }

    public void deleteUtility(long id){
        em.getTransaction().begin();
        em.remove(getUtility(id));
        em.getTransaction().commit();
    }

    public Utility getUtility(long id){
        return em.find(Utility.class, id);
    }

    public void updateUtility(Utility utility){
        em.getTransaction().begin();
        em.merge(utility);
        em.getTransaction().commit();
    }

    public List<Utility> getAll(){
        String queryString = "SELECT u FROM Utility u";
        Query query = em.createQuery(queryString);
        return query.getResultList();
    }
    public List<Utility> findAllUtilitiesByName(String name) {
        String queryString = "SELECT u FROM Utility u WHERE LOWER(u.name) = :name";
        Query query = em.createQuery(queryString);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
