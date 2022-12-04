package kr.co.softcampus.model;

import javax.servlet.http.HttpServletRequest;

public class TestService {
	
	public static int minus(HttpServletRequest request) {
		String str1 = request.getParameter("data1");
		String str2 = request.getParameter("data2");
		
		int data1 = Integer.parseInt(str1);
		int data2 = Integer.parseInt(str2);
		
		int result = 1000 - data1 - data2;
		System.out.println(result);
		
		return result;
	}
}
