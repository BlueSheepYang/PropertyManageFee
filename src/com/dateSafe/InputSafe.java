package com.dateSafe;

public class InputSafe {

	public boolean checkPayMoneyInputSafe(String str) {
		boolean flag = true;
		 char[] chars = str.toCharArray();
	    for(int i = 0;i<chars.length;i++) {
	    	if((int)chars[i]<48||(int)chars[i]>57) {
	    		flag = false;
	    	}
			 
	    }
	    return flag;
	}
}
