package FinalProject.Handlers;

import FinalProject.Beans.Course;
import FinalProject.DBUtils.DBUtil;
import FinalProject.Interfaces.CourseInterface;
import java.util.List;

public class CourseHandle implements CourseInterface{
	
	@Override
	public List<Course> getCourses(){
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getCourses();
	}

	@Override
	public boolean addCourse(String ssn, String courseID, String grade) {
		DBUtil dbUtil = new DBUtil();
		if(dbUtil.addCourse(ssn, courseID, grade)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delCourse(String ssn, String courseID) {
		DBUtil dbUtil = new DBUtil();
		if(dbUtil.delCourse(ssn, courseID)){
			return true;
		}else{
			return false;
		}
	}
}
