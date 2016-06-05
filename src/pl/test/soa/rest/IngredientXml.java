package pl.test.soa.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="ingredient")
class IngredientXml {
	public String ingredientName;
	public int ingredientId;
	public int quantity;
	
	public IngredientXml() {
		
	}
	
	public IngredientXml(int id, String name, int quantity) {
		this.ingredientId = id;
		this.ingredientName = name;
		this.quantity = quantity;
	}
}