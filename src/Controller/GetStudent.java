package Controller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery; 
import Model.Student;

public class GetStudent {

	public static Student fetchByID(int ID){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Student student = entitymanager.find(Student.class, ID);; 
		
		entitymanager.close( );
		emfactory.close( );
		return student; 
	}
	
	public static List<Student> fetchAll(){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		TypedQuery<Student> studentQuery = entitymanager.createQuery("SELECT q FROM Student q", Student.class);
		
		List<Student> students = studentQuery.getResultList();
		
		entitymanager.close( );
		emfactory.close( );
		return students; 
	}
	
	
}
