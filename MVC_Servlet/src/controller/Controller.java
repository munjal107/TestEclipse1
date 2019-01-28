package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modal.Student;
import dao.StudenDao;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		ArrayList<Student> slist=StudenDao.getStudentList();
		
		//System.out.println(slist.size());
		
		request.setAttribute("slist", slist);
		RequestDispatcher rd=request.getRequestDispatcher("slist.jsp");
		rd.forward(request, response);
		
//	doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		Student s = new Student();
		s.setUname(uname);
		s.setPass(pass);
		System.out.println(uname+"  "+pass);
		boolean status = StudenDao.validate(s);
		if(status) {
			//response.sendRedirect("login-success.jsp");
			request.getRequestDispatcher("login-success.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("login-fail.jsp").forward(request,response);
		}
	}

}
