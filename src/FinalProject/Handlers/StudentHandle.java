package FinalProject.Handlers;

import FinalProject.Interfaces.StudentInterface;
import FinalProject.DBUtils.DBUtil;
import FinalProject.Beans.Student;

public class StudentHandle implements StudentInterface {

	@Override
	public Student getStudentInfo(String ssn){
		DBUtil dbUtil = new DBUtil();
		return dbUtil.getStudentInfo(ssn);
	}
}
