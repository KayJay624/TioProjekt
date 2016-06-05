package com.mycompany;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utils.DatabaseConnection;
import com.utils.HibernateUtil;

public class PositionDOA {

	public void addPosition(Position c, Set ing) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
        	 System.out.println("Position Saving!");
            trns = session.beginTransaction();
            //session.save(c.getCategory());
            c.setIngredients(ing);
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
 
    public void deletePosition(int categotyId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Position cust = (Position) session.load(Position.class, new Integer(categotyId));
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
 
    public void updatePosition(Position c) {
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
 
    public List<Position> getAllPosition() {
        List<Position> users = new ArrayList<Position>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Position").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
    public List<Position> getAllPosition(int categoryId) {
        List<Position> users = new ArrayList<Position>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            users = session.createQuery("from Position where category_id = "+ categoryId).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
    public List<String> getAllPositionNames(int categoryId) {
        List<String> users = new ArrayList<String>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //users = session.createQuery("select * from Category").list();
            users = session.createQuery("select name from Position where category_id = "+ categoryId).list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
    
    public List<String> getAllPositionNames() {
        List<String> users = new ArrayList<String>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            //users = session.createQuery("select * from Category").list();
            users = session.createQuery("select name from Position").list();
            
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return users;
    }
 
    public Position getPositionByName(String cid) {
       //System.out.println(cid);
        Position cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Position where name = :cid";
            Query query = session.createQuery(queryString);
            query.setParameter("cid", cid);
            cust = (Position) query.uniqueResult();
            //System.out.println(cust.getName() + " Imie to me");
            List<Position> list = query.list();
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
    
    public Position getPositionById(int cid) {
        //System.out.println(cid);
        Position cust = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Position where id = :cid";
            Query query = session.createQuery(queryString);
            query.setParameter("cid", cid);
            cust = (Position) query.uniqueResult();
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
    
    public static LinkedList<Position> getTopPositions ()  {
		Connection c = DatabaseConnection.getInstance().getPsqlConnection();		
		try {
			Statement stmt = c.createStatement();
			String query="select sum(quantity) as counter, name from transactions join position on (position_id = id) "
					+ "group by name order by counter desc NULLS LAST;";
			
			final LinkedList<Position> result = new LinkedList<Position>();
			//System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
					int count  = rs.getInt(1);									
					String name = rs.getString("name");
					Position p = new PositionDOA().getPositionByName(name);
					result.add(new Position(p, count));
			}

			stmt.close();


			return result;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;


	}
}

