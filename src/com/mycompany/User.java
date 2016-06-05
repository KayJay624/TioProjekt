package com.mycompany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class User {
	private int userId;
	private String userName;
	private String passwd;
	private Role role;
	private Set transactions;
	private Date from;
	private Date to;
		
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set getTransactions() {
		return transactions;
	}

	public void setTransactions(Set transactions) {
		this.transactions = transactions;
	}

	public User() {
		from =  new Date();
		to = new Date();
	}
	
	
	
	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public List<Transact> getAllTransaction() {
        return TransactionDAO.getTransactions(TransactionDAO.getUserId(userName), from.toString(), to.toString());
    }
	
	
	
}
