package kr.co.softcampus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.softcampus.model.TestService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청한 주소 가져오기
		String url = request.getRequestURI();
		// View로 사용할 JSP
		String viewName = null;
		
		if(url.contains("main.mvc")) {
			//System.out.println("main요청");
			viewName = "main.jsp";
		}else if(url.contains("test1.mvc")) {
			//System.out.println("test1요청");
			viewName = "test1.jsp";
			String str1 = request.getParameter("data1");
			String str2 = request.getParameter("data2");
			
			int data1 = Integer.parseInt(str1);
			int data2 = Integer.parseInt(str2);
			
			int result = data1 + data2;
			
			//result라는 이름으로 result값을 jsp에서 받겠다.
			request.setAttribute("result", result);
			
		}else if(url.contains("test2.mvc")) {
			//System.out.println("test2요청");
			viewName = "test2.jsp";
			
			//모델 요청
			int result = TestService.minus(request);
			request.setAttribute("result", result);
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
