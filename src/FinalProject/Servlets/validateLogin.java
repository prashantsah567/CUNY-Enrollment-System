package FinalProject.Servlets;

import java.io.*;
import javax.servlet.*; 
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.util.List;

import FinalProject.Handlers.StudentHandle;
import FinalProject.Handlers.EnrollmentHandle;
import FinalProject.Beans.Student;
import FinalProject.Beans.EnrollBean;
import FinalProject.Interfaces.EnrollmentInterface;
import FinalProject.Interfaces.StudentInterface;
import FinalProject.Handlers.URLHandle;

//this servlet validates the ssn and display all the necessary information on the myRegist.jsp page
@WebServlet("/validate-login")
public class validateLogin extends HttpServlet {
	
	private StudentInterface studentInterface = new StudentHandle();
	private EnrollmentInterface enrollmentInterface = new EnrollmentHandle();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String address;
		String ssn = request.getParameter("ssn").trim();
		
		Student studentInfo = null;
		
		if(ssn.isEmpty()){
			ssn = "";
		}else{
			studentInfo = studentInterface.getStudentInfo(ssn);
		}
		
		//Sets session - (later used for drop or enroll courses)
		HttpSession session = request.getSession();
		session.setAttribute("student", studentInfo);
		
		if(ssn == ""){
			request.setAttribute("Invalid Input", "");
			address = URLHandle.ERROR_LOGIN.getUrl();
		}else if(studentInfo != null){
			List<EnrollBean> enrollData = enrollmentInterface.getStudentCourses(ssn);
			
			request.setAttribute("student", studentInfo);
			request.setAttribute("enroll", enrollData);
			address = URLHandle.SUCCESS.getUrl();
		}else{
			request.setAttribute("Invalid Input", ssn);
			address = URLHandle.ERROR_LOGIN.getUrl();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { doGet(request, response); }
}
