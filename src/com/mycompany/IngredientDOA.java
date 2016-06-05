package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtil;

public class IngredientDOA {

	public void addIngredient(Ingredient c) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(c);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public void deleteIngredient(int categotyId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Ingredient cust = (Ingredient) session.load(Ingredient.class, new Integer(categotyId));
            session.delete(cust);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public void updateIngredient(Ingredient c) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(c);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> users = new ArrayList<Ingredient>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //session.
            users =(List)session.createQuery("FROM Ingredient").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
    public List<Ingredient> getIngredientById(String cid) {
        System.out.println(cid);
        Ingredient cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Ingredient where id= :id";
            Query query = session.createQuery(queryString);
            query.setString("id", cid);
            cust = (Ingredient) query.uniqueResult();
            List<Ingredient> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
    
    public List<String> getAllIngredientsNames() {
        List<String> users = new ArrayList<String>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //users = session.createQuery("select * from Category").list();
            users = session.createQuery("select distinct name from Ingredient").list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
    public List<String> getAllIngredientsNames(int id) {
        List<String> users = new ArrayList<String>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //users = session.createQuery("select * from Category").list();
            users = session.createQuery("select distinct name from Ingredient where position_id=" + id).list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
    public List<Ingredient> getIngredientsByName(String cid) {
        System.out.println(cid);
        Ingredient cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Ingredient where name = :cid";
            Query query = session.createQuery(queryString);
            query.setParameter("cid", cid);
            cust = (Ingredient) query.uniqueResult();
            //System.out.println(cust.getName() + " Imie to me");
            List<Ingredient> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
    
    public Ingredient getIngredientByName(String cid) {
        System.out.println(cid);
        Ingredient cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Ingredient where name = :cid";
            Query query = session.createQuery(queryString);
            query.setParameter("cid", cid);
            //cust = (Ingredient) query.uniqueResult();
            //System.out.println(cust.getName() + " Imie to me");
            List<Ingredient> list = query.list();
            if (list.size() > 0) {
                return list.get(0);
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
    
    public List<Ingredient> getAllIngredients(int positionId) {
        List<Ingredient> users = new ArrayList<Ingredient>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Ingredient where position_id = "+positionId).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
}

