package FinalProject.Servlets;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import FinalProject.Handlers.URLHandle;
import FinalProject.Handlers.CourseHandle;
import FinalProject.Beans.Student;
import FinalProject.Interfaces.CourseInterface;

//this servlet is to drop a course after user click on drop button (on enroll.jsp)
@WebServlet("/drop-class")
public class dropClass extends HttpServlet {
	
	private CourseInterface courseInterface = new CourseHandle();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Student student = (Student) request.getSession().getAttribute("student");
		String ssn = student.getSsn();
		String courseID = request.getParameter("courseID");
		
		String address;
		
		if(courseInterface.delCourse(ssn, courseID)){
			address = "validate-login?ssn="+ ssn;
		}else{
			address = URLHandle.ERROR_DROP.getUrl();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { doGet(request, response); }
}
