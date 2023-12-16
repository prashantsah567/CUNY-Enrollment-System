package FinalProject.Beans;

public class Student {
	private final String ssn, fname, mname, lname, dob, address, phone, zip, deptId;
	
	public Student(	String ssn,	String fname, String mname,	String lname,
					String dob,	String address,	String phone, String zip, String deptId){
		this.ssn = ssn;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.zip = zip;
		this.deptId = deptId;
		
	}
	
	public String getSsn() {
		return ssn;
	}

	public String getFname() {
		return fname;
	}

	public String getMname() {
		return mname;
	}

	public String getLname() {
		return lname;
	}

	public String getDob() {
		return dob;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getZip() {
		return zip;
	}

	public String getDeptId() {
		return deptId;
	}
	
	
}