package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "students")
public class Student{
	@Id
	private int id; 
	
	private String firstName; 
	private String lastName; 
	private int classPeriod;
	//getters and setters
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
	public int getClassPeriod() {
		return classPeriod;
	}
	public void setClassPeriod(int classPeriod) {
		this.classPeriod = classPeriod;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 	
	//constructors
	public Student(String firstName_input, String lastName_input, int classPeriod_input, int id_input ){
		id = id_input;
		firstName = firstName_input;
		lastName = lastName_input; 
		classPeriod = classPeriod_input;
	}
	public Student(){
	}
	
	@Override
	public String toString(){
		return ("Student: " + firstName + " " + lastName + " Class Period: P." + classPeriod + " ID: " + id);
	}
	
}
