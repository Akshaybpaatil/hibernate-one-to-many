package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;
import com.practice.hibernate.demo.entity.Student;

public class DeleteInstructorDetail {

	public static void main(String[] args) {

		// create a session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Instructor.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//start the transaction
			session.beginTransaction();
		
			//get the instructor detail object
			int id = 1;
			InstructorDetail instructorDetail = 
					session.get(InstructorDetail.class, id);
			
			//print the instructor detail

			System.out.println("InstructorDetail:"+instructorDetail);
			
			//print the associated instructor
			System.out.println("associated Instructor:"+instructorDetail.getInstructor());
			
			//delete the instructor details
			System.out.println("Deleting the InstructorDetail:"+instructorDetail);
			session.delete(instructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			factory.close();
		}
	}

}
