package com.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@ApplicationScoped
public class UsersBean {
	 private ArrayList<User> users;
	 
	 public UsersBean() {
		users = new ArrayList<User>();
	    }

	 public ArrayList<User> getUsers() {
		 return users;
	 }
	 
	 public void addUser(String login, String role) {
		 users.add(new User(login, new Date(), role));
	 }
	 
	 public void delUser(String login) {		 
		 for(User u : users) {
			 if(u.login.equals(login)) {
				users.remove(u); 
				break;
			 }
		 }
	 }	 
	 public ArrayList<User> sortASC() {
		 Collections.sort(users, new Comparator<User>() {
			  @Override
			  public int compare(User o1, User o2) {
			    return  o2.date.compareTo(o1.date);
			  }
			});
		 return users;
	 }
	 
	 public ArrayList<User> sortDSC() {
		 Collections.sort(users, new Comparator<User>() {
			  @Override
			  public int compare(User o1, User o2) {
			    return o2.date.compareTo(o1.date);
			  }
			});
		 Collections.reverse(users);
		 return users;
	 }
	 
	 public class User {
		 public String login;
		 public Date date;
		 public String role;
		 
		 public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public User(String l, Date d, String role) {
			 this.login = l;
			 this.date = d;
			 this.role = role;
		 }
	}
	 

}

