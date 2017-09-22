package model;





public class register {
	private int idreg;
	private int studid;
	private int courseid;
	private String startcourse;
	
	@Override
	public String toString() {
		return "register [idreg=" + idreg + ", studid=" + studid
				+ ", courseid=" + courseid + ", startcourse=" + startcourse
				+ "]";
	}
	public int getIdreg() {
		return idreg;
	}
	public void setIdreg(int idreg) {
		this.idreg = idreg;
	}
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getStartcourse() {
		return startcourse;
	}
	public void setStartcourse(String startcourse) {
		this.startcourse = startcourse;
	}
	public register(int idreg, int studid, int courseid, String startcourse) {
		super();
		this.idreg = idreg;
		this.studid = studid;
		this.courseid = courseid;
		this.startcourse = startcourse;
	}
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
