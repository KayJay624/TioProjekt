package com.mycompany;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Spinner {
	private int num;

	public int getNum() {
		System.out.println("Get num: " + num);
		return num;
	}

	public void setNum(int num) {
		System.out.println("Set num: " + this.num);
		this.num = num;
	}
	
	
}
