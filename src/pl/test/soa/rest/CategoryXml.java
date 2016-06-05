package pl.test.soa.rest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.mycompany.Category;
import com.mycompany.Position;
import com.mycompany.PositionDOA;

@XmlRootElement(name ="category")
class CategoryXml {
	public String categoryName;
	public int categoryId;
	public List<PositionXml> positions;
	
	public CategoryXml() {
		
	}
	
	public CategoryXml(int id, String name) {
		this.categoryId = id;
		this.categoryName = name;
		this.positions = new ArrayList<PositionXml>();
		List<Position> posi = new PositionDOA().getAllPosition(id);
		for(Position p : posi) {
			this.positions.add(new PositionXml(p.getId(), p.getName()));
		}
	}
	
	public Category toCategory() {
		return new Category(this.categoryName);
	}
}