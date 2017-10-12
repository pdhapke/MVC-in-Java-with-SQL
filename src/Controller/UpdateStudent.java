package Controller;
import Model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class UpdateStudent {

	public static String update(Student student){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Student studentToUpdate = entitymanager.find(Student.class, student.getId());
		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setClassPeriod(student.getClassPeriod());
		studentToUpdate.setId(student.getId());
		entitymanager.getTransaction().commit();
		
		Student updatedStudent = GetStudent.fetchByID(student.getId());
		entitymanager.close( );
		emfactory.close( );
		return updatedStudent.toString();
	}
	
	public static void delete(int ID){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Student Database EclipseMVC" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Student toBeDeleted = entitymanager.find(Student.class, ID); 
		entitymanager.remove(toBeDeleted);
		entitymanager.getTransaction().commit();
		entitymanager.close( );
		emfactory.close( );
		
	}
	
	
	
}
