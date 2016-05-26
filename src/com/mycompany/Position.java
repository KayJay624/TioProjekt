package com.mycompany;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Position implements java.io.Serializable{
	private int id;
	private Category category;
	private Set ingredients;
	private String name;
		
	public Position(String name, Category category) {
		super();
		this.category = category;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category categoryId) {
		this.category = categoryId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set ingredients) {
		this.ingredients = ingredients;
	}
	
	public void savePosotion() {   
		PositionDOA dao = new PositionDOA();
        dao.addPosition(this, null);
        System.out.println("Position Saved Successfull!");
        clearAll();
    }
    
	public void updateCategory() {      
		PositionDOA dao = new PositionDOA();
        dao.updatePosition(this);
        System.out.println("Category Updated Successfull!");
        clearAll();
    }
    public void deleteCategory() {
    	CategoryDAO dao = new CategoryDAO();
        dao.deleteCategory(this.id);
        System.out.println("Category Deleted Successfull!");
        clearAll();
    }
 
    public List<Category> getAllCategories() {
        List<Category> users = new ArrayList<Category>();
        CategoryDAO dao = new CategoryDAO();
        users = dao.getAllCategories();
        return users;
    }
    
    public List<String> getAllCategoriesNames() {
        List<String> users = new ArrayList<String>();
        CategoryDAO dao = new CategoryDAO();
        users = dao.getAllCategoriesNames();
        return users;
    }
 
    public void fullInfo() {
    	CategoryDAO dao = new CategoryDAO();
        List<Category> lc = dao.getCategoryByName(selectedname);
        System.out.println(lc.get(0).name);
        this.id = lc.get(0).id;
        this.name = lc.get(0).name;

    }
 
    private void clearAll() {
        this.id = 0;
        this.name = "";
        
    }
	

}
