package com.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.student.dto.Student;

@Repository // Connected with the database
public class StudentDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStudent(Student student) {
		et.begin();
		em.persist(student);
		et.commit();
	}

	public void updateStudent(Student student) {
		et.begin();
		em.merge(student);
		et.commit();
	}

	public void deleteStudent(Student student) {
		et.begin();
		em.remove(student);
		et.commit();
	}

	public Student findStudent(int id) {
		return em.find(Student.class, id);
	}
 //This is 
	public List<Student> findAllStudents() {
		Query query = em.createQuery("select s from Student s");// jpql Query
		List<Student> students = query.getResultList();
		return students;
	}

}
