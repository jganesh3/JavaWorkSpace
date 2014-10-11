package hibernate.java.mySql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HiernateTest {
	static ServiceRegistry serviceRegistry;
	public static void main(String[] args) {
	
		Employee e2=new Employee();
		e2.setDepartment("testing");
		e2.setFirstName("G");
		e2.setLastName("J");
		e2.setSalary(100000);
		
		//Create configuration object
		Configuration configuration = new Configuration();
	    configuration.configure();
		
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		
		//Create Session
		Session session=sessionFactory.openSession();
		//Start transaction
		try {
			session.beginTransaction();
			//save the object
			
			session.save(e2);
			
			//commit the transaction
			session.getTransaction().commit();
			
			session.close();
		} catch (Exception e) {
			//Roll back the transaction in case of any errors
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
		
		Employee e3=null;
		//Open session
		session=sessionFactory.openSession();
		//start new transaction
		session.beginTransaction();
		//Retrieve data from the database
		e3=(Employee)session.get(Employee.class, 1);
		
		//Now print the data
		System.out.println("Fetched record from the database"+e3.getFirstName());
		
		
		session.close();
		
		
		
		

	}

}
