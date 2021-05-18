package com.example.common;

import java.math.BigDecimal;

public class Test {
	public static void main(String []args) {
		BigDecimal aaBigDecimal= null;
		BigDecimal bbBigDecimal =new BigDecimal(11.11);
		String ccString=aaBigDecimal+"";
		String ddString=bbBigDecimal+"";
		String eeString=bbBigDecimal.toString();
		String ffString=bbBigDecimal.toPlainString();
		System.out.println(ccString+":"+ddString+":"+eeString+":"+ffString);
		
	}
}
