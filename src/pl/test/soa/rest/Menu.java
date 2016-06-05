package pl.test.soa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.mycompany.Category;
import com.mycompany.CategoryDAO;
import com.mycompany.Ingredient;
import com.mycompany.IngredientDOA;
import com.mycompany.Position;
import com.mycompany.PositionDOA;


@XmlRootElement(name ="menu")
public class Menu {
	@XmlElement(name="category")
	private List<CategoryXml> categories; 

	public List<CategoryXml> getCategories() {
		return categories;
	}

	public Menu() {
		this.categories = new ArrayList<CategoryXml>();
		List<Category> cate = new CategoryDAO().getAllCategories();
		for(Category c : cate) {
			this.categories.add(new CategoryXml(c.getId(), c.getName()));
		}
	}
	
	public static CategoryXml getCategory(String catName) {
		//this.categories = new ArrayList<CategoryXml>();
		Category c = new CategoryDAO().getCategoryByItsName(catName);
		if(c != null) {
			return new CategoryXml(c.getId(), c.getName());
		} else {
			return null;
		}
		
	}
	
	public static PositionXml getPosition(String posName) {
		//this.categories = new ArrayList<CategoryXml>();
		Position p = new PositionDOA().getPositionByName(posName);
		if(p != null) {
			return new PositionXml(p.getId(), p.getName());
		} else {			
	     	throw new WebApplicationException(Response.Status.NOT_FOUND);	        
		}
		
	}
	
}	
	
	
	
	
	