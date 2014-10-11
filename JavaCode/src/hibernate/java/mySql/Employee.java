package hibernate.java.mySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity               //if we give @Entity (name="emp") this will give table name as emp as well as change Entity name from Employee to emp
@Table(name="emp")   // This annotation will give the table name while keeping same entity name.
public class Employee {
	@Column (name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int empID;
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
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
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
