package dto;

public class Dto {	
	
	private String ename;
	private int eno;
	private String depname;
	private String hiredate;
	
	public Dto() {
		
	}

	public Dto(String ename, int eno, String depname, String hiredate) {
		super();
		this.ename = ename;
		this.eno = eno;
		this.depname = depname;
		this.hiredate = hiredate;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "Dto [ename=" + ename + ", eno=" + eno + ", depname=" + depname + ", hiredate=" + hiredate + "]";
	}

	
	
	
}
