package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.NamedQuery;

@ManagedBean
@SessionScoped
public class Ingredient implements java.io.Serializable{
	private int id;
	private String name;
	private int quantity;
	private String selectedIng;
	
	public Ingredient() {
	}
	
	public Ingredient(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}
	
	public Ingredient(Ingredient i) {
		
		this.name = i.name;
		this.quantity = i.quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Ingredient obj2 = (Ingredient)obj;
	      if((this.id == obj2.getId()) && (this.name.equals(obj2.getName())))
	      {
	         return true;
	      }
	      return false;
	}
	
	public int hashCode() {
	      int tmp = 0;
	      tmp = ( id + name ).hashCode();
	      return tmp;
	}
	
	public void saveIngredient() {   
		IngredientDOA dao = new IngredientDOA();
		dao.addIngredient(this);
        System.out.println("Ingredient Saved Successfull!");
        clearAll();
    }
    
	public void updateIngredient() {      
		IngredientDOA dao = new IngredientDOA();
        dao.updateIngredient(this);
        System.out.println("Ingredient Updated Successfull!");
        clearAll();
    }
    public void deletePosition() {
    	IngredientDOA dao = new IngredientDOA();
        dao.deleteIngredient(this.id);
        System.out.println("Ingredient Deleted Successfull!");
        clearAll();
    }
    
    public void deletePosition(Ingredient i){
    	IngredientDOA dao = new IngredientDOA();
        dao.deleteIngredient(i.id);
        System.out.println("Ingredient Deleted Successfull!");
    }
 
    public List<Ingredient> getAllIngredients() {
        List<Ingredient> users = new ArrayList<Ingredient>();
        IngredientDOA dao = new IngredientDOA();
        users = dao.getAllIngredients();
        return users;
    }
    
    public List<Ingredient> getAllIngredients(int id) {
        List<Ingredient> users = new ArrayList<Ingredient>();
        IngredientDOA dao = new IngredientDOA();
        users = dao.getAllIngredients(id);
        return users;
    }
    
    public List<String> getAllIngredientsNames() {
        List<String> users = new ArrayList<String>();
        IngredientDOA dao = new IngredientDOA();
        users = dao.getAllIngredientsNames();
        return users;
    }
    
    public List<String> getAllIngredientsNames(int i) {
        List<String> users = new ArrayList<String>();
        IngredientDOA dao = new IngredientDOA();
        users = dao.getAllIngredientsNames(i);
        return users;
    }
 
    public void fullInfo() {
    	IngredientDOA dao = new IngredientDOA();
        List<Ingredient> lc = dao.getIngredientsByName(selectedIng);
        System.out.println(lc.get(0).name);
        this.id = lc.get(0).id;
        this.name = lc.get(0).name;
        this.quantity = lc.get(0).quantity;       

    }
 
    private void clearAll() {
        this.id = 0;
        this.name = "";
        this.quantity = 0;
        
    }

}
