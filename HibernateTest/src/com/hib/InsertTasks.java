package com.hib;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class InsertTasks {

	public static void main(String[] args) 
	{
        try {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
     
			SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			Session session = factory.openSession();  
			Transaction t = session.beginTransaction();
			
			CustomTask task = new CustomTask();
			task.setTask_id(001);
			task.setTitle("Hibernate Task");
			task.setCreated_at(new Date());
			task.setStart_date(new Date());
			task.setDescription("This task describes the first project to be built in hibernate");
			task.setDue_date(new Date());
			task.setPriority(1);
			task.setStatus(1);
			
			session.save(task);  
			t.commit();  
			System.out.println("successfully saved");    
			factory.close();  
			session.close();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to save the task to database : "+e.getMessage());
		}  
	}
}
