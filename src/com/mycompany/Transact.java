package com.mycompany;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Transact  implements java.io.Serializable{
	private int transaction_id;
	private String date;
	private Position position;
	private boolean state;
	private String comment;
	private LinkedList<Position> positions = new LinkedList<Position>();
	
	public Transact() {
		
	}
	
	public void addPosition(Position p) {
		this.positions.add(p);
	}
	
	public LinkedList<Position> getPositions() {
		return positions;
	}



	public void setPositions(LinkedList<Position> positions) {
		this.positions = positions;
	}



	public Transact(int transaction_id, String date, Position position, boolean state, String comment) {
		super();
		this.transaction_id = transaction_id;
		this.date = date;
		this.position = position;
		this.state = state;
		this.comment = comment;
	}



	public Transact(String date, Position position) {
		super();
		this.date = date;
		this.position = position;
	}

	

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void saveTransaction() {   
		this.position = this.positions.get(0);
		//this.date = new Date().toString();
		TransactionDAO.addTransaction(this, 2);
		System.out.println("sdfsdf234324");
        clearAll();
    }
	
	private void clearAll() {
		this.transaction_id = 0;
		this.date = null;
		this.position = null;
		this.state = false;
		this.comment = null;
		this.positions = new LinkedList<Position>();
        
    }
}
