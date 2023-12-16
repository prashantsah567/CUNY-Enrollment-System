package FinalProject.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FinalProject.Beans.Student;
import FinalProject.Interfaces.CourseInterface;
import FinalProject.Handlers.CourseHandle;
import FinalProject.Handlers.URLHandle;

//this servlet is to register a new course after user clicks on Register button (on enroll.jsp)
@WebServlet("/registerNewClass")
public class registerNewClass extends HttpServlet {
	
	private CourseInterface courseInterface = new CourseHandle();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("student");
		String ssn = student.getSsn();
		String courseID = request.getParameter("courseID");
		String grade = request.getParameter("grade");
		
		String address;
		
		if(courseInterface.addCourse(ssn, courseID, grade)){
			address = "validate-login?ssn="+ ssn;
		}else{
			address = URLHandle.ERROR_REGISTER.getUrl();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
