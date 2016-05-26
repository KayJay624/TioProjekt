package com.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.Category;
import com.mycompany.Contact;
import com.mycompany.Ingredient;
import com.mycompany.Position;
  
public class HibernateUtil {
  
    private static final SessionFactory sessionFactory=buildSessionFactory();
  
   public static SessionFactory buildSessionFactory(){
        try {
        	 Configuration conf = new Configuration();
             conf.addClass(com.mycompany.Contact.class);
             conf.addClass(com.mycompany.Category.class);
             conf.addClass(com.mycompany.Ingredient.class);
             conf.addClass(com.mycompany.Position.class);
             conf.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
             conf.configure();
            return conf.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}