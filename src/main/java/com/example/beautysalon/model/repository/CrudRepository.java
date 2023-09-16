package com.example.beautysalon.model.repository;

import com.example.beautysalon.model.utils.Jpa;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class CrudRepository<T, I> implements AutoCloseable {
    private EntityManager entityManager;

    public T insert(T t) {
        entityManager = Jpa.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(t);
        entityTransaction.commit();
        return t;
    }

    public T update(T t) {
        entityManager = Jpa.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(t);
        entityTransaction.commit();
        return t;
    }

    public T delete(Class<T> tClass, I id) {
        entityManager = Jpa.getJpa().getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T entity = entityManager.find(tClass, id);
        entityManager.remove(entity);
        entityTransaction.commit();
        return entity;
    }

    public T selectById(Class<T> tClass, I id) {
        entityManager = Jpa.getJpa().getEntityManager();
        T entity = entityManager.find(tClass, id);
        return entity;
    }
   
    public List<T> selectAll(Class<T> tClass) {
        entityManager = Jpa.getJpa().getEntityManager();
        String sql = "select entity from " + tClass.getAnnotation(Entity.class).name() + " entity ";
        Query query = entityManager.createQuery(sql);
        List<T> tList = query.getResultList();
        return tList;
    }

    public List<T> executeQuery(String queryName, Map<String, Object> paramMap) {
        entityManager = Jpa.getJpa().getEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        if (paramMap != null)
            for (String key : paramMap.keySet()) {
                query.setParameter(key, paramMap.get(key));
            }

        List<T> tList = query.getResultList();
        return tList;
    }


    @Override
    public void close() throws Exception {
        entityManager.close();
    }


}
