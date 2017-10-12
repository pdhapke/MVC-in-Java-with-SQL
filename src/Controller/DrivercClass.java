package Controller;
import Model.Student;

import java.util.List;
import java.util.Scanner;

public class DrivercClass {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		boolean runMenuAgain = true; 
		while(runMenuAgain){
			runMenuAgain = mainMenu(in); 
		}
		in.close();
	}
	
	private static boolean mainMenu(Scanner in){
		boolean runAgain = true; 
		System.out.println();
		System.out.print("************ Main Menu ************\n"
					   + "Please choose an option to proceed\n"
					   + "Enter 1 to - Add a student file\n"
					   + "Enter 2 to - Get a student file\n"
					   + "Enter 3 to - Update a student file\n"
					   + "Enter 4 to - Delete a student file\n"
					   + " - or Enter any other key to exit\n");
		System.out.print("Choice: ");
		
		String choice = in.next();
		
		switch(choice) {
			case "1": 
				addAStudentFile(in); 
			break; 
			case "2": 
				getAStudentFile(in);
			break; 
			case "3": 
				updateAStudentFile(in);
			break; 
			case "4": 
				deleteAStudentFile(in);
			break; 
			default: 
				System.out.print("Goodbye!");
				runAgain = false; 
		};  
		
		return runAgain; 
	}	
		
	private static void addAStudentFile(Scanner in){
		System.out.println("This will create a student file");
		System.out.println("Please enter the students first name");
		System.out.print("First Name: ");
		String fname = in.next();
		System.out.println("Please enter the students last name");
		System.out.print("Last Name: ");
		String lname = in.next(); 
		System.out.println("Please enter the students class period");
		System.out.print("Class period: ");
		int period = in.nextInt(); 
		System.out.println("Please enter the students ID number");
		System.out.print("ID: ");
		int ID = in.nextInt();
		CreateStudent.addStudent(fname, lname, period, ID);
	}
	
	private static void getAStudentFile(Scanner in){
		System.out.println("This will print a student file");
		System.out.println("Please enter the students ID number");
		System.out.print("ID: ");
		int ID = in.nextInt();
		Student student = GetStudent.fetchByID(ID);
		System.out.println(student.toString());
	}
	
	private static void updateAStudentFile(Scanner in){
		System.out.println("This will update a student file");
		System.out.println("Please enter the students ID number");
		System.out.print("ID: ");
		int ID = in.nextInt();
		System.out.println("Please enter the students first name");
		System.out.print("First Name: ");
		String fname = in.next();
		System.out.println("Please enter the students last name");
		System.out.print("Last Name: ");
		String lname = in.next(); 
		System.out.println("Please enter the students class period");
		System.out.print("Class period: ");
		int period = in.nextInt(); 
		UpdateStudent.update(new Student(fname, lname, period, ID));
	}
	
	private static void deleteAStudentFile(Scanner in){
		System.out.println("This will delete a student file");
		System.out.println("Please enter the students ID number");
		System.out.print("ID: ");
		int ID = in.nextInt();
		UpdateStudent.delete(ID);
	}
	
	public static void testDatabase() {
		//this section will test adding students to the database
		CreateStudent.addStudent("Sage", "Blue", 2, 101001); 
	
		Student[] class_roster = new Student[5];
		class_roster[0] = new Student("Jordan", "Burns", 2, 101002);
		class_roster[1] = new Student("Emma", "Bair", 2, 101003);
		class_roster[2] = new Student("Sam", "Brown", 2, 101004);
		class_roster[3] = new Student("Shane", "Lamb", 2, 101005);
		class_roster[4] = new Student("Janell", "Lewis", 2, 101006);
		CreateStudent.addStudents(class_roster);
		
		//this section will test retrieving and printing student information
		System.out.println("#########Queries#########");
		System.out.println("----Single Student----");
		Student studentByID = GetStudent.fetchByID(101002);
		System.out.println("");
		System.out.println(studentByID.toString());
		System.out.println("----All Students----");
		List<Student> fullList = GetStudent.fetchAll(); 
		
		for(Student i:fullList){
			System.out.println(i.toString());
		}

		//this section tests updating students
		System.out.println("----Updated Student----");
		Student replacement = new Student("James", "Bond", 8, 101002);
		System.out.println(UpdateStudent.update(replacement));
		
		//this section deletes a record
		UpdateStudent.delete(101002);
		
		System.out.println("All tests returned postive, clearing the database"); 
		
		//this section will delete all the remaining records
		
		UpdateStudent.delete(101001);
		UpdateStudent.delete(101003);
		UpdateStudent.delete(101004);
		UpdateStudent.delete(101005);
		UpdateStudent.delete(101006);

		
		
	}
}
