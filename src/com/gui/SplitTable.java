package com.gui;

import java.util.Vector;

public class SplitTable {
	
	public Vector lastMember(int firstNum ,int num,Vector date) {
		Vector newDate = new Vector();
		for(int i = 0;i<num;i++) {
			newDate.add(date.get(firstNum-i));
		}
		return newDate;
	}
	
	public Vector nextMember(int firstNum ,int num,Vector date) {
		Vector newDate = new Vector();
		for(int i = 0;i<num;i++) {
			newDate.add(date.get(firstNum+i));
			System.out.println(date.get(firstNum+i));
		}
		return newDate;
	}

}
