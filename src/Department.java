
public class Department {
	private int departmentId;
	private String name;
	public int getDepartmentId() {
		return departmentId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Department(String name) {
		super();
		this.name = name;
	}
	
	
}
