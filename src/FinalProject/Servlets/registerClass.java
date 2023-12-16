package FinalProject.Servlets;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.List;

import FinalProject.Interfaces.CourseInterface;
import FinalProject.Handlers.CourseHandle;
import FinalProject.Handlers.URLHandle;
import FinalProject.Beans.Course;

//this servlet takes the user to enroll.jsp after they click on Enroll button (from myRegister.jsp)
@WebServlet("/register-class")
public class registerClass extends HttpServlet {
	
	private CourseInterface courseInterface = new CourseHandle();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//to send courses information to enroll.jsp
		String address;
		List<Course> courseInfo = courseInterface.getCourses();
		
		request.setAttribute("courses", courseInfo);
		address = URLHandle.SUCCESS_ENROLL.getUrl();

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { doGet(request, response); }

}
