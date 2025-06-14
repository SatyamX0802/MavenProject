package com.example.HibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.HibernateProject.Utils.HIbernateUtils;
import com.example.HibernateProject.entities.Students;

public class Services {
	SessionFactory sessionFactory = new HIbernateUtils().getSessionFactory();
	
	public void saveData(Students student) {
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.persist(student);
			transaction.commit();
		}
	}
	
	public Students getStudents(int id) {
		try(Session session = sessionFactory.openSession()){
			Students student = session.find(Students.class, id);
			return student;
		}
	}
	
	public void updateStudent(int id, Students student) {
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			Students St = session.find(Students.class, id);
			if(St!=null) {
				St.setName(student.getName());
				St.setAge(student.getAge());
				St = session.merge(St);
			}
			transaction.commit();
		}
	}
	
	public void deleteStudent(int id) {
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			Students st = session.find(Students.class, id);
			session.remove(st);
			transaction.commit();
		}
	}
}
