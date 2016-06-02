package com.beans;

import java.util.Hashtable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class OrderBean {

	private Hashtable produkty;
	
	public OrderBean() {
        this.produkty = new Hashtable();
    }

    public void add(String produkt) {
        if (this.produkty.containsKey(produkt)) {
            Integer ilosc = (Integer)this.produkty.get(produkt);        
            this.produkty.put(produkt, new Integer(ilosc+1));
        
        } else {
            this.produkty.put(produkt, new Integer(1));
        }
    }

    public Hashtable getProdukty() {
        return this.produkty;
    }
    
    public int getSize() {
        return produkty.size();
    }

    public void setNewItem(String id_item) {
        this.add(id_item);
    }

    public void setRemoveItem(String id_item) {
        this.produkty.remove(id_item);
    }

}
