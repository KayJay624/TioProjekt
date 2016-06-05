package pl.test.soa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.mycompany.Ingredient;
import com.mycompany.IngredientDOA;

@XmlRootElement(name ="position")
class PositionXml {
	public String positionName;
	public int positionId;
	public List<IngredientXml> ingredients;
	
	public PositionXml() {
		
	}
	
	public PositionXml(int id, String name) {
		this.positionId = id;
		this.positionName = name;
		this.ingredients = new ArrayList<IngredientXml>();
		List<Ingredient> ingr = new IngredientDOA().getAllIngredients(id);
		for(Ingredient i : ingr) {
			this.ingredients.add(new IngredientXml(i.getId(), i.getName(), i.getQuantity()));
		}
	}
}