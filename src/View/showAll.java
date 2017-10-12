package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.GetStudent;
import Model.Student;


/**
 * Servlet implementation class showAll
 */
@WebServlet("/showAll")
public class showAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		
		
		List<Student> fullList = GetStudent.fetchAll(); 

		page.print("<style> table, th, td { border: 1px solid black; border-collapse: collapse;} th, td { padding: 6px;} </style>");
		
		
		
		
		
		
		page.print("<br>");
		page.print("	<h3> Full Student list: </h3>");
		page.print("		<div id = 'tablediv'>");
		page.print(" 			<table>");
		page.print(" 				 <tr>");
		page.print(" 				 <th>Student ID</th>");
		page.print("  				 <th>First Name</th>");
		page.print(" 				 <th>Last Name</th>");
		page.print(" 				 <th>Class Period</th>");
		page.print("			     </tr>");
		
		 
      
		for(Student i:fullList){
			page.print("<tr>");
			page.print("	<td>" + i.getId()  + "</td>");
			page.print("	<td>"+ i.getFirstName() + "</td>");
			page.print("	<td>"+ i.getLastName() + "</td>");
			page.print("	<td>" + i.getClassPeriod() + "</td>");
			page.print("</tr>");
		}

	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
