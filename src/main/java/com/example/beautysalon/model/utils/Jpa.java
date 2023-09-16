package com.example.beautysalon.model.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {

    private static Jpa jpa = new Jpa();
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mft");

    private Jpa() {
    }

    public static Jpa getJpa() {
        return jpa;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
