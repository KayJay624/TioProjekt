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

@Path("/menu")
public class MenuResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String name;
	
	public MenuResource() {}
	
	public MenuResource(UriInfo uriInfo, Request request, String name) {
	    this.uriInfo = uriInfo;
	    this.request = request;
	    this.name= name;
	}
	
	
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml")
	public Menu getMenu() {
		return new Menu();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/xml/{cateName}")
	public CategoryXml getCategory(@PathParam("cateName") String cateName) {
		return Menu.getCategory(cateName);
	}
	
	//Application integration     
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Category getCategory() {
		  
		  return new CategoryDAO().getCategoryByItsName(name);
	  }
	  
	  // for the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public Category getCategoryHTML() {
	    
		  return new CategoryDAO().getCategoryByItsName(name);
	  }
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putCategory(JAXBElement<CategoryXml> cate) {
		CategoryXml c = cate.getValue();
	    return putAndGetResponse(c);
	}
	  
	@DELETE
	public void deleteCategory() {		
	    new CategoryDAO().deleteCategory(new CategoryDAO().getCategoryByItsName(name).getId());
	 }
	  
	private Response putAndGetResponse(CategoryXml cate) {
		Response res;		
		res = Response.created(uriInfo.getAbsolutePath()).build();
		
		//TodoDao.instance.getModel().put(todo.getId(), todo);
		new CategoryDAO().addCategory(cate.toCategory());
		return res;
	}
	
	// ---------------------------------------------------------------------
	
	
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

