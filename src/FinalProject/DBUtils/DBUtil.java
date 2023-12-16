package FinalProject.DBUtils;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import FinalProject.Beans.Student;
import FinalProject.Beans.Course;
import FinalProject.Beans.EnrollBean;

public class DBUtil {
	
	private Connection connection = null;
	
	//method to start a connection
	private void startConnection(){
		try{
			// Load the JDBC driver
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    System.out.println("Driver loaded");
		    // Connect to a database   
		    connection = DriverManager.getConnection
		  	      ("jdbc:mysql://database-cuny.c4piq2ndsfvh.us-west-1.rds.amazonaws.com:3306/CUNY_DB" , "cst4713", "password1");      
		    System.out.println("Database connected"); 
		}catch (ClassNotFoundException e){
			System.out.println("Class not found");
			e.printStackTrace();
		}catch (SQLException e){
			System.out.println(" SQL error");
			e.printStackTrace();
		}
		
	}
	
	//method to close a connection
	private void closeConnection(){
		try{
			connection.close();
		}catch (SQLException e){
			System.out.println("Unable to close connection");
			e.printStackTrace();
		}
	}
	
	//get student information*****************************************************
	
	public Student getStudentInfo(String ssn){
		startConnection();
		String sqlQuery = "Select * from Students Where ssn = ?";
		Student studentInfo = null;
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
	          // Set the value for the placeholder
	          preparedStatement.setString(1, ssn);
	
	          // Execute the query
	          try (ResultSet resultSet = preparedStatement.executeQuery()) {
	              // Process the result set
	              if (resultSet.next()) {
	                  studentInfo = new Student(resultSet.getString(1),
	                		  					resultSet.getString(2),
	                		  					resultSet.getString(3),
	                		  					resultSet.getString(4),
	                		  					resultSet.getString(5),
	                		  					resultSet.getString(6),
	                		  					resultSet.getString(7),
	                		  					resultSet.getString(8),
	                		  					resultSet.getString(9));
	                  System.out.println("Student info retrieved");
	                  return studentInfo;
	              }
	          }
	      } catch (SQLException e) {
	    	  e.printStackTrace();
	      } finally{
				closeConnection();
	      }
		
		return null;
	}
	
	//get student enrollment List*****************************************************
	
	public List<EnrollBean> getStudentCourses(String ssn){
		startConnection();
		String sqlQuery = "Select c.courseID, c.title, e.grade from Course c, Enrollment e "
						+ "Where c.courseID = e.courseID and e.ssn = ? Order by c.title";
		List<EnrollBean> enrollData = new ArrayList<>(); //to store the returned data
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, ssn);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String courseID = resultSet.getString("courseID");
                    String title = resultSet.getString("title");
                    String grade = resultSet.getString("grade");

                    EnrollBean enrollBean = new EnrollBean(courseID, title, grade);
                    enrollData.add(enrollBean);
                }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally{
			closeConnection();
		}
		
		return enrollData;
	}
	
	//get Courses list*****************************************************
	
	public List<Course> getCourses() {
	    startConnection();

	    String sqlQuery = "SELECT courseID, title FROM Course ORDER BY title";
	    List<Course> courseInfo = new ArrayList<>();

	    try (Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sqlQuery)) {

	        while (resultSet.next()) {
	            String courseID = resultSet.getString(1);
	            String title = resultSet.getString(2);

	            Course course = new Course(courseID, title);
	            courseInfo.add(course);
	        }
	    } catch (SQLException e) {
	    	System.out.println("SQL Query not executed -- for getCourses() method");
	        e.printStackTrace();
	    } finally {
	        closeConnection();
	    }

	    return courseInfo;
	}
	
	//add course to student*****************************************************
	
	public boolean addCourse(String ssn, String courseID, String grade){
		startConnection();
		String sqlQuery = "Insert into Enrollment Values (?, ?, NOW(), ?)";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseID);
			preparedStatement.setString(3, grade);
			
			//only add if course if not already there
			if(!findCourse(ssn, courseID)){
				preparedStatement.executeUpdate();
				System.out.println("Course Added with courseID "+ courseID);
				preparedStatement.close();
				return true;
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally{
			closeConnection();
		}
		
		return false;
	}
	
	//delete a course*****************************************************
	
	public boolean delCourse(String ssn, String courseID){
		startConnection();
		String sqlQuery = "Delete From Enrollment Where ssn = ? and courseId = ?";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseID);
			
			if(findCourse(ssn, courseID)){
				preparedStatement.executeUpdate();
				System.out.println("Course Deleted: CourseID - "+courseID);
				preparedStatement.close();
				closeConnection();
				return true;
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeConnection();
		}

		return false;
	}
	
	//to find a course (if exists in database or not)*****************************************************
	
	private boolean findCourse(String ssn, String courseID){
		String sqlQuery = "Select * From Enrollment Where ssn = ? and courseId = ?";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, ssn);
			preparedStatement.setString(2, courseID);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				System.out.println("Course found: CourseID - "+ courseID);
				preparedStatement.close();
				resultSet.close();
				return true;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
}