package com.mycompany;

public class Ingredient {
	private int id;
	private String name;
	private int quantity;
	
	public Ingredient() {
	}
	
	public Ingredient(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
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

}
