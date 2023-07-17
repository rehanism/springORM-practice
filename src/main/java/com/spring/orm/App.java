package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {    
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
       
//       Student student = new Student(256,"Harsh","Pune");
//       int r = studentDao.insert(student);
//       System.out.println("Added" +r);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go==true) {
        System.out.println("PRESS 1 to add new student");
        System.out.println("PRESS 2 to display all students");
        System.out.println("PRESS 3 to get detail of single student");
        System.out.println("PRESS 4 to delete students");
        System.out.println("PRESS 5 to update student");
        System.out.println("PRESS 6 to exit");
        try {
        	int input=Integer.parseInt(br.readLine());
        	
        	switch (input)
        	{
        	case 1:
        		//add a new student 
        		//taking input from user
        		System.out.println("Enter user id : ");
        		int uId=Integer.parseInt(br.readLine());
        		System.out.println("Enter user Name : ");
        		String uName=br.readLine();
        		System.out.println("Enter user City : ");
        		String  uCity=br.readLine();
        		
        		
        		Student student = new Student();
        		student.setId(uId);
        		student.setName(uName);
        		student.setCity(uCity);
        		
        		int r = studentDao.insert(student);
        		System.out.println("Student added "+r);
        		System.out.println("************************");
        		System.out.println();
        		
        		break;
        	case 2:
        		//display all students
        		
        		List<Student> allStudents=studentDao.getAllStudents();
        		for(Student st: allStudents)
        		{
        			System.out.println("Id : "+ st.getId());
        			System.out.println("Name : "+ st.getName());
        			System.out.println("City : "+ st.getCity());
        			System.out.println("--------------------------------");
        		}
        		System.out.println("******************************");
        		break;
        	case 3:
        		//display single student details
        		System.out.println("Enter user id : ");
        		int userId=Integer.parseInt(br.readLine());
        		Student student1 = studentDao.getstudent(userId);
        		System.out.println("Id : "+ student1.getId());
    			System.out.println("Name : "+ student1.getName());
    			System.out.println("City : "+ student1.getCity());
    			System.out.println("--------------------------------");
    		System.out.println("******************************");
        		break;
        	case 4:
        		//delete students
        		System.out.println("Enter user id : ");
        		int id=Integer.parseInt(br.readLine());
        		studentDao.deleteStudent(id);
        		System.out.println("Student deleted");
        		System.out.println("******************************");
        		break;
        	case 5:
        		//update students
        		System.out.println("Press 1, 2, and 3 for updating the id, name, and city respectively");
        		int i=Integer.parseInt(br.readLine());
        		//Student student3 = studentDao.update();
        		switch (i)
        		{
        	case 1: System.out.println("Enter id to update");
        			id=Integer.parseInt(br.readLine());
        			
        			System.out.println("Id updated");
        			break;
        	case 2: 
        		}
        		break;
        	case 6:
        		//exit
        		go=false;
        		break;
        	}
        	
        }
        catch(Exception e){
        	System.out.println("Invalid input");
        	System.out.println(e.getMessage());
        }
        }
        System.out.println("Thank you");
    }
}
