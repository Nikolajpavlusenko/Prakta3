package one.model.service;


import one.model.entity.Payment;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class PaymentService {

    public EntityManager em = Persistence.createEntityManagerFactory("UTILITIES").createEntityManager();

    public Payment payment(Payment payment){
        em.getTransaction().begin();
        Payment paymentFromDB = em.merge(payment);
        em.getTransaction().commit();
        return paymentFromDB;
    }

    public void deletePayment(long id){
        em.getTransaction().begin();
        em.remove(getPayment(id));
        em.getTransaction().commit();
    }

    public Payment getPayment(long id){
        return em.find(Payment.class, id);
    }

    public void updatePayment(Payment payment){
        em.getTransaction().begin();
        em.merge(payment);
        em.getTransaction().commit();
    }
    public List<Payment> getAll(){
        TypedQuery<Payment> namedQuery = em.createNamedQuery("Payment.getAll", Payment.class);
        return namedQuery.getResultList();
    }

    public List<Payment> findAllPaymentByDate(LocalDate date) {
        String queryString = "SELECT p FROM Payment p WHERE LOWER(p.date) = :date";
        Query query = em.createQuery(queryString);
        query.setParameter("date", date);
        return query.getResultList();
    }


}
