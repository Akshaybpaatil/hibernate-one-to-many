package com.practice.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.practice.hibernate.demo.entity.Instructor;
import com.practice.hibernate.demo.entity.InstructorDetail;
import com.practice.hibernate.demo.entity.Student;

public class CreateInstructor {

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
			//create a student object
			Instructor instructor = 
					new Instructor("Abhi", "Patil", "abhibpatil@gmail.com");
			
			InstructorDetail instructorDetail =
					new InstructorDetail("http://www.youtube.com/youtube", 
							"Gaming!!");
			
			instructor.setInstructorDetail(instructorDetail);
			
			//start the transaction
			session.beginTransaction();
			
			//save the instructor
			System.out.println("Saving instructor:"+instructor);
			session.save(instructor); 
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}
