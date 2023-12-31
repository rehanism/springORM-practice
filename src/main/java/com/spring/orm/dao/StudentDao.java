package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	//save student
	@Transactional
	public int insert(Student student) {
		//insert
		
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
	//get single Data
	public Student getstudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
		
	}
	
	//get all rows
	public List<Student> getAllStudents(){
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}
	
	//deleting data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student =this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	//updating the data
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}
