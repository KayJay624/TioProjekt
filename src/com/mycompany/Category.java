package com.mycompany;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Category implements java.io.Serializable{
	private int id;
	private String name;
	private String selectedname;
	
	public Category() {
	
	}
	
	public Category(String name) {
		super();
		this.name = name;
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
	
	public String getSelectedname() {
        return selectedname;
    }
 
    public void setSelectedname(String selectedname) {
        this.selectedname = selectedname;
    }
	
	public void saveCategory() {   
        CategoryDAO dao = new CategoryDAO();
        dao.addCategory(this);
        System.out.println("Category Saved Successfull!");
        clearAll();
    }
    
	public void updateCategory() {      
		CategoryDAO dao = new CategoryDAO();
        dao.updateCategory(this);
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
