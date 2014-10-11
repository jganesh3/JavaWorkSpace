package hibernate.java.mySql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HiernateTest {
	static ServiceRegistry serviceRegistry;
	public static void main(String[] args) {
	
		Employee e1=new Employee();
		e1.setDepartment("development");
		e1.setEmpID("1");
		e1.setFirstName("Ganesh");
		e1.setLastName("Joshi");
		e1.setSalary(100000);
		
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
			session.save(e1);
			//commit the transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			//Roll back the transaction in case of any errors
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
		
		
		
		
		
		

	}

}
