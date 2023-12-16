package FinalProject.Handlers;

import java.util.List;
import FinalProject.Beans.EnrollBean;
import FinalProject.Interfaces.EnrollmentInterface;
import FinalProject.DBUtils.DBUtil;

public class EnrollmentHandle implements EnrollmentInterface {
	
	@Override
	public List<EnrollBean> getStudentCourses(String ssn){
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getStudentCourses(ssn);
	}
}
