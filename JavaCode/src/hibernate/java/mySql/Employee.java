package hibernate.java.mySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="EMP_MAIN")
public class Employee {
	@Column (name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Id
	@Column(name="emp_id")
	private String empID;
	@Column(name="salary_current")
	private double salary;
	@Column(name="Department")
	private String department;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	

}
