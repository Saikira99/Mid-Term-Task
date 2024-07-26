package com.midterm.task.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BankAccountUtil {
    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test5");
        EntityManager em=emf.createEntityManager();
        return em;
    }
}
