package com.example.HibernateProject.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HIbernateUtils {
	private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError("Error in creating Session Factory: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

}
