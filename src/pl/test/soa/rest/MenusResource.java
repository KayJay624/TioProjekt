package pl.test.soa.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.mycompany.Category;
import com.mycompany.CategoryDAO;
import com.mycompany.Ingredient;
import com.mycompany.Position;
import com.mycompany.PositionDOA;

//@Path("/hello")
@Path("/menus")
public class MenusResource {
	 @Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	
	  @GET
		@Produces(MediaType.APPLICATION_XML)
		@Path("{cateName}")
		public CategoryXml getCategory(@PathParam("cateName") String cateName) {
		  	System.out.println("uzywam getCategory{cateName}");
			return Menu.getCategory(cateName);
		}
	  
	  @GET
		@Produces(MediaType.APPLICATION_XML)
		@Path("/position/{posiName}")
		public PositionXml getPosition(@PathParam("posiName") String posiName) {
		  	System.out.println("uzywam getPosition{posiName}");
			return Menu.getPosition(posiName);
		}
	
	@GET
	  @Produces(MediaType.TEXT_XML)
	  public List<CategoryXml> getCategoriessBrowser() {
		System.out.println("uzywam getCategoriesBrowser");
	    List<CategoryXml> categories = new ArrayList<CategoryXml>();
	    List<Category> ca =new CategoryDAO().getAllCategories();
	    for(Category c : ca) {
	    	categories.add(new CategoryXml(c.getId(), c.getName()));
	    }
	    	
	    return categories;
	  }

	  @GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public List<CategoryXml> getCategories() {
		  System.out.println("uzywam getCategories");
		  List<CategoryXml> categories = new ArrayList<CategoryXml>();
		    List<Category> ca =new CategoryDAO().getAllCategories();
		    for(Category c : ca) {
		    	categories.add(new CategoryXml(c.getId(), c.getName()));
		    }
		    	
		    return categories;
	  }

	  
	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newCategory(
		  @FormParam("id") int id,
	      @FormParam("name") String name,
	      @Context HttpServletResponse servletResponse) throws IOException {
	    
		  Category cate = new Category(name);
		  new CategoryDAO().addCategory(cate);
		  System.out.println("Dodano kategorie: " + name);
		  servletResponse.sendRedirect("../../index.xhtml");
	  }
	  
	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  @Path("/position")
	  public void newPosition(
		  //@FormParam("id") int id,
	      @FormParam("name") String name,
	      @FormParam("category") String category,
	      @Context HttpServletResponse servletResponse) throws IOException {
		  
		  /*for(String s : selectedIng) {
				Ingredient i =(Ingredient)daoI.getIngredientByName(s);
				this.ingredients.add(new Ingredient(i));
			}*/
			List<Category> lc = new CategoryDAO().getCategoryByName(category);
			Position posi = new Position(name, lc.get(0));
			
			new PositionDOA().addPosition(posi, null);
		 		 
		  System.out.println("Dodano pozycje: " + name + " do kategori: " + category);
		  servletResponse.sendRedirect("http://localhost:8080/TioProjekt/");
	  }

	  // Defines that the next path parameter after todos is
	  // treated as a parameter and passed to the TodoResources
	  // Allows to type http://localhost:8080/com.vogella.jersey.todo/rest/todos/1
	  // 1 will be treaded as parameter todo and passed to TodoResource
	  /*@Path("{todo}")
	  public MenuResource getCategory(@PathParam("todo") String name) {
		  return new MenuResource(uriInfo, request, name);
	  }*/
	
/* @GET
 @Produces(MediaType.APPLICATION_JSON)
 @Path("/message/json")
 public Message sendJSONMessage() {
 return new Message("title", "body");
 }
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 @Path("/to/{name}")
 public String sayHelloTo(@PathParam("name") String name) {
 return "Hello there " + name + "!";
 }
 @PUT
 @Consumes(MediaType.APPLICATION_XML)
 @Path("/message/put")
 public void receiveXMLMessage(Message message) {
 System.out.println(message.getTitle());
 System.out.println(message.getBody());
 }*/
 
}


