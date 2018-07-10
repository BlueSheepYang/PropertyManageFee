package com.dateSafe;

public class dateSafe {
	
	static final int keyWord = 10;
	
	public static String TransferToAscii(String str) {
		  StringBuffer sbu = new StringBuffer();
		  char[] chars = str.toCharArray();
		  for(int i = 0;i<chars.length;i++) {
			  if(i!=chars.length-1) {
				  sbu.append((int)chars[i]-keyWord).append(",");
			  }
			  else {
				  sbu.append((int)chars[i]-keyWord);
			  }
		  }
		  return sbu.toString();
	  }
	public static String TransferToString(String str) {
		  String[] str1 = str.split(",");
		  StringBuffer sbu = new StringBuffer();
		  char[] chars = str.toCharArray();
		  for(int i = 0;i<str1.length;i++) {
				  sbu.append((char) (Integer.parseInt(str1[i])+keyWord));
		  }
		  return sbu.toString();
	  }

}
