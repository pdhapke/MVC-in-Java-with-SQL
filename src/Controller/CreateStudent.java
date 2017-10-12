package Controller;
import Model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CreateStudent {

	public static void addStudent(String first_name, String last_name, int class_period, int student_id){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Student student = new Student( ); 
		student.setId(student_id);
		student.setFirstName(first_name);
		student.setLastName( last_name );
		student.setClassPeriod( class_period);
		entitymanager.persist( student );
		entitymanager.getTransaction( ).commit( );
		
		entitymanager.close( );
		emfactory.close( );
		
	}
	
	public static void addStudent(Student student){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		entitymanager.persist( student );
		entitymanager.getTransaction( ).commit( );
		
		entitymanager.close( );
		emfactory.close( );
		}
	
	
	
	public static void addStudents(Student[] students){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		for (Student student:students){
			entitymanager.persist( student );
		}
		entitymanager.getTransaction( ).commit( );
		entitymanager.close( );
		emfactory.close( );
		
	}
	
	
	
	
	

}