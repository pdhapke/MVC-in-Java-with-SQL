package View;
import Model.Student;
import Controller.CreateStudent;
import Controller.UpdateStudent;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.CreateStudent;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/modifyStudent")
public class modifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter page = response.getWriter();
		String first_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		int classperiod = Integer.parseInt(request.getParameter("period"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		Student student = new Student(first_name, last_name, classperiod, id);
		UpdateStudent.update(student);
		
		
		page.print("<h3> Student Modify succesfully!</h3><div> <br><input type='button' onclick='location.href=\"/Main\";' value='Return to Mainpage'/></div>");
	}

}
