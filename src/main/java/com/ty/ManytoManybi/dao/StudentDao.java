package com.ty.ManytoManybi.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.ManytoManybi.dto.Student;
import com.ty.ManytoManybi.dto.Teacher;


public class StudentDao 
{
	public static void main(String[] args) 
	{
		
		Student student1= new Student();
		student1.setName("Tharun");
		student1.setPhone(8095945);
		
		Student student2= new Student();
		student2.setName("Kulli");
		student2.setPhone(143);
		
		Student student3= new Student();
		student3.setName("Suhas");
		student3.setPhone(550);
		
		Teacher teacher1= new Teacher();
		teacher1.setName("shankar");
		teacher1.setSub("java");
		
		Teacher teacher2= new Teacher();
		teacher2.setName("preetam");
		teacher2.setSub("adv java");
		
		Teacher teacher3= new Teacher();
		teacher3.setName("daali");
		teacher3.setSub("mysql");
		
		List<Teacher> l1= new ArrayList<Teacher>();
		l1.add(teacher1);
		l1.add(teacher3);
		student1.setTeachers(l1);
		
		List<Teacher> l2= new ArrayList<Teacher>();
		l2.add(teacher2);
		l2.add(teacher3);
		student2.setTeachers(l2);
		
		List<Teacher> l3= new ArrayList<Teacher>();
		l3.add(teacher1);
		l3.add(teacher3);
		l3.add(teacher2);
		student3.setTeachers(l3);
		
		List<Student> ls1= new ArrayList<Student>();
		ls1.add(student1);
		ls1.add(student3);
		teacher1.setStudents(ls1);
		
		List<Student> ls2= new ArrayList<Student>();
		ls2.add(student2);
		ls2.add(student3);
		teacher2.setStudents(ls2);
		
		List<Student> ls3= new ArrayList<Student>();
		ls1.add(student1);
		ls1.add(student2);
		teacher3.setStudents(ls3);
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("tharun");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(teacher3);
		entityTransaction.commit();
		
	}

}
