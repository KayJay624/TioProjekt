package com.mycompany;

import java.util.ArrayList;
import java.util.HashSet;
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
	private String selectedPos;
	private String selectedCat;
	private LinkedList<String> selectedIng = new LinkedList<String>();
		
	public Position() {
		
	}
	
	public Position(String name, Category category) {
		super();
		this.category = category;
		this.name = name;
	}
	
	
	public String getSelectedPos() {
		return selectedPos;
	}

	public void setSelectedPos(String selectedPos) {
		this.selectedPos = selectedPos;
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
	
	
	
	public LinkedList<String> getSelectedIng() {
		return selectedIng;
	}

	public void setSelectedIng(LinkedList<String> selectedIng) {
		this.selectedIng = selectedIng;
	}

	public String getSelectedCat() {
		return selectedCat;
	}

	public void setSelectedCat(String selectedCat) {
		this.selectedCat = selectedCat;
	}

	public void savePosition() {   
		PositionDOA dao = new PositionDOA();
		CategoryDAO daoC = new CategoryDAO();
		IngredientDOA daoI = new IngredientDOA();
		this.ingredients = new HashSet();
		for(String s : selectedIng) {
			Ingredient i =(Ingredient)daoI.getIngredientByName(s);
			this.ingredients.add(new Ingredient(i));
		}
		List<Category> lc = daoC.getCategoryByName(selectedCat);
        //System.out.println(lc.get(0).name);
        this.category = lc.get(0);
		
		dao.addPosition(this, ingredients);
        System.out.println("Position Saved Successfull!");
        clearAll();
    }
    
	public void updatePosition() {      
		PositionDOA dao = new PositionDOA();
		CategoryDAO daoC = new CategoryDAO();
		this.category = daoC.getCategoryByName(selectedCat).get(0);
        dao.updatePosition(this);
        System.out.println("Position Updated Successfull!");
        clearAll();
    }
    public void deletePosition() {
    	PositionDOA dao = new PositionDOA();
        dao.deletePosition(this.id);
        System.out.println("Category Deleted Successfull!");
        clearAll();
    }
    
    public void deletePosition(Position p){
    	PositionDOA dao = new PositionDOA();
        dao.deletePosition(p.id);
        System.out.println("Position Deleted Successfull!");
    }
 
    public List<Position> getAllPositions() {
        List<Position> users = new ArrayList<Position>();
        PositionDOA dao = new PositionDOA();
        users = dao.getAllPosition();
        return users;
    }
    
    public List<Position> getAllPositions(int id) {
        List<Position> users = new ArrayList<Position>();
        PositionDOA dao = new PositionDOA();
        users = dao.getAllPosition(id);
        return users;
    }
    
    public List<String> getAllPositionsNames() {
        List<String> users = new ArrayList<String>();
        PositionDOA dao = new PositionDOA();
        users = dao.getAllPositionNames();
        return users;
    }
    
    public List<String> getAllPositionNames(int i) {
        List<String> users = new ArrayList<String>();
        PositionDOA dao = new PositionDOA();
        users = dao.getAllPositionNames(i);
        return users;
    }
 
    public void fullInfo() {
    	PositionDOA dao = new PositionDOA();
        List<Position> lc = dao.getPositionByName(selectedPos);
        System.out.println(lc.get(0).name);
        this.id = lc.get(0).id;
        this.name = lc.get(0).name;
        this.category = lc.get(0).category;
        this.selectedCat = lc.get(0).category.getName();

    }
 
    private void clearAll() {
        this.id = 0;
        this.name = "";
        this.category = null;
        this.selectedIng = new LinkedList();
        
    }
	

}
