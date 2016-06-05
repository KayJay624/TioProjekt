package pl.test.soa.rest;

import java.util.HashMap;
import java.util.Map;

public enum MenuDao {
	instance;
	  
	private Map<String, Menu> contentProvider = new HashMap<>();
	  
	private MenuDao() {
	    
	   
	    
	  }
	  public Map<String, Menu> getModel(){
	    return contentProvider;
	  }
	  
	} 

