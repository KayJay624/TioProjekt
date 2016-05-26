package com.mycompany;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
/**
 * A sample program that demonstrates how to perform simple CRUD operations
 * with Hibernate framework.
 * @author www.codejava.net
 *
 */
public class ContactManager {
    public static void main(String[] args) {
    	/*CategoryDAO cat = new CategoryDAO();
    	
    	Ingredient ing1 = new Ingredient(3,"Buraki");
    	Category cat1 = new Category(17,"Rybrtya");
    	List<Ingredient> ingr = ing.getAllIngredients();
 
    	//System.out.println(ingr);
    	//ingr.add(ing.getAllIngredients().get(0));
    	//ingr.add(ing.getAllIngredients().get(1));
    	System.out.println(ingr);
    	
    	PositionDOA pos = new PositionDOA();
    	Position pos1 = new Position(1, cat.getAllCategories().get(0), ing.getAllIngredients(), "Buraczane zimioki");
    	pos.addPosition(pos1);*/
    	
    	/*PositionDOA pos = new PositionDOA();
    	List<Ingredient> set1 = new ArrayList<Ingredient>();     
    	CategoryDAO cat = new CategoryDAO();
    	Category cat1 = new Category("Pierogi");//(Category) cat.getCategoryById(13);       
        Position p = new Position("Pierogi ruskie", cat1);
        pos.addPosition(p);*/
    	
    	HashSet set1 = new HashSet();
        set1.add(new Ingredient("wiecej burakow", 1));
        set1.add(new Ingredient("Kotlet", 1));
        set1.add(new Ingredient("Buraki", 1));
    	
        PositionDOA pos = new PositionDOA();
        CategoryDAO cat = new CategoryDAO();
        Category cat1 = (Category) cat.getCategoryById(14); 
        pos.addPosition(new Position("Kotlet z burakami", cat1), set1);
        System.out.println(pos.getAllPositionNames(14));
    	//ing.addIngredient(ing1);
    	//cat.addCategory(cat1);
    	//System.out.println(pos.getAllPosition().get(0));
    	//System.out.println(cat.getAllCategories());
      /* Configuration conf = new Configuration();
       conf.addClass(com.mycompany.Contact.class);
       conf.addClass(com.mycompany.Category.class);
       conf.setProperty("hibernate.temp.use_jdbc_metadata_defaults","false");
       conf.configure();
       ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
       SessionFactory sf = conf.buildSessionFactory(sr);
       Session session = sf.openSession();

       Transaction tx = session.beginTransaction();*/
      /* Category cat1 = new Category("Obiad");
       int  id = (Integer)session.save(cat1);
       System.out.println("created id: " + id);
       Category cat2 = (Category) session.get(Category.class, new Integer(3));
       System.out.println(cat2.getName());*/
       //Contact contact1 = new Contact(3,"Nam", "hainatuatgmail.com", "Vietnam", "0904277091");
       //int  id = (Integer) session.save(contact1);
       //System.out.println("created id: " + id);
       /*Contact contact3 = (Contact) session.get(Contact.class, new Integer(2));
       if (contact3 == null) {
           System.out.println("There is no Contact object with id=1");
       } else {
           System.out.println("Contact3's name: " + contact3.getName());
       }*/
       
      // tx.commit();

        //
        //session.save(contact1);
        /*Contact contact2 = new Contact("Bill", "billatgmail.com", "USA", "18001900");
        Serializable id = session.save(contact2);
        //session.getTransaction().commit();
        System.out.println("created id: " + id);
         
        // loads a new object from database
        Contact contact3 = (Contact) session.get(Contact.class, new Integer(0));
        if (contact3 == null) {
            System.out.println("There is no Contact object with id=1");
        } else {
            System.out.println("Contact3's name: " + contact3.getName());
        }
         
        // loads an object which is assumed exists
        Contact contact4 = (Contact) session.load(Contact.class, new Integer(0));
        System.out.println("Contact4's name: " + contact4.getName());
         
        // updates a loaded instance of a Contact object
        Contact contact5 = (Contact) session.load(Contact.class, new Integer(0));
        contact5.setEmail("info1atcompany.com");
        contact5.setTelephone("1234567890");
        session.update(contact5);
        // updates a detached instance of a Contact object
        Contact contact6 = new Contact(2, "Jobs", "jobsatapplet.com", "Cupertino", "0123456789");
        session.update(contact6);
         
        // deletes an object
        Contact contact7 = new Contact();
        contact7.setId(7);
        session.delete(contact7);
        // deletes a loaded instance of an object
        Contact contact8 = (Contact) session.load(Contact.class, new Integer(8));
        session.delete(contact8);*/
         
        // commits the transaction and closes the session
        //session.getTransaction().commit();
        //session.close();
         
    }
}