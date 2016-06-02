package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.HibernateUtil;

public class CategoryDAO {

	public void addCategory(Category c) {
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
 
    public void deleteCategory(int categotyId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Category cust = (Category) session.load(Category.class, new Integer(categotyId));
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
 
    public void updateCategory(Category c) {
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
 
    public List<Category> getAllCategories() {
        List<Category> users = new ArrayList<Category>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //users = session.createQuery("select * from Category").list();
            users = (List)session.createQuery("FROM Category").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
    public List<String> getAllCategoriesNames() {
        List<String> users = new ArrayList<String>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //users = session.createQuery("select * from Category").list();
            users = session.createQuery("select name from Category").list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
    public List<Category> getCategoryByName(String cid) {
        System.out.println(cid);
        Category cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Category where name = :cid";
            Query query = session.createQuery(queryString);
            query.setParameter("cid", cid);
            cust = (Category) query.uniqueResult();
            //System.out.println(cust.getName() + " Imie to me");
            List<Category> list = query.list();
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
    
    public Category getCategoryById(int cid) {
        System.out.println(cid);
        Category cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Category where id = :cid";
            Query query = session.createQuery(queryString);
            query.setParameter("cid", cid);
            cust = (Category) query.uniqueResult();
            //System.out.println(cust.getName() + " Imie to me");
            List<Category> list = query.list();
            if (list.size() > 0) {
                return cust;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }

}