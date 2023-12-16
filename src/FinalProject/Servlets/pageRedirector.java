package FinalProject.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FinalProject.Beans.Student;

//this servlet is to redirect to different pages after receiving input from enroll.jsp - depends on which button they clicked
@WebServlet("/enroll-page-redirector")
public class pageRedirector extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//to pass ssn for exit button as they expecting ssn as parameter
		Student student = (Student) request.getSession().getAttribute("student");
		String ssn = student.getSsn();
				
		String action = (String) request.getParameter("action");
		String courseID = (String) request.getParameter("course");
		String grade = (String) request.getParameter("grade");
		
		String address = "";
		
		
		if(action != null && courseID != null && grade != null){
			switch(action){
			case "exit":
				address = "validate-login?ssn="+ ssn;
				break;
			case "drop":
				address = "drop-class?courseID="+ courseID;
				break;
			case "register": 
				address = "registerNewClass?courseID="+ courseID + "&grade="+ grade;
				break;
			default:
				address = "validate-login?ssn="+ ssn;
			}
		}
		
		if(!address.isEmpty()){
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}

}
