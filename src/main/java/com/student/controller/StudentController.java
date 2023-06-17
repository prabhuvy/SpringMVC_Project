package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import com.student.dao.StudentDao;
import com.student.dto.Student;

@Controller
public class StudentController {
	@Autowired// Dependencies Injection -Injecting the Object/bean of StudentDao
	private StudentDao studentDao;
	//StudentDao studentDao=new StudentDao();
	//
	@RequestMapping("/")//It is the Base Mapping  for our Project,when ever we run our Project
	//the request will come and hit this particular method every time.
	
	//here we have set a view for "home.jsp" so that file will be rendered 
	//on my browser and no object/model is added in this  method.
	public ModelAndView homePage()  //
	{
		ModelAndView modelAndView=new ModelAndView();//it is class and having some methods() to perform operstions
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}
	//when the user click on "Add Student" link it will bring him to this method.
	//A view is set for "register.jsp" so that file will be rendered on the 
	//browser,and an null object(new Student())is added and sent to the 
	//jsp file.
	@RequestMapping ("/register")
	public ModelAndView registerStudent()//to Fetch the data
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("student",new Student());//key-student and value-new Student()
		modelAndView.setViewName("register.jsp");
		return modelAndView;
	}
	//after adding the values to the null object the request will come and hit this method 
	//@ModelAttribute -here we are recieving the same object that we sent from 
	//from the register.jsp file (with values).
	//in these particular method we are saving the data in my database using 
	//syudentDao.saveStudent().
	//And we are setting an view for "home.jsp,,.".
	@RequestMapping("/save")
	public ModelAndView saveStudent(@ModelAttribute Student student){ //@ModelAttribute-for recieveing object
		
		ModelAndView modelAndView=new ModelAndView();
		studentDao.saveStudent(student);
		modelAndView.setViewName("home.jsp");
		return modelAndView;
	}
	//When we click on (viewStudent) link it will come and hit this 
	//method 
	//here we have set a view for view.jsp
	//And adding an object of list of students fetched from the database 
	//using (studentDao.findAllStudent()) with a key ("students").
	@RequestMapping("/view")
	public ModelAndView findStudents()
	{
		ModelAndView modelAndView=new ModelAndView();//it provides Architecture 
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("students",studentDao.findAllStudents());
		return modelAndView;
	}
	//when we click on EDIT link for any student present in the table 
	//it will redirect us to this particular method .
	
	//@RequestParam -Here we are receiving the id of that particular 
	//student object from the view.jsp file.
	//After thst we are finding that student object from the data base using 
	//(studentDao.findStudent(id)) and giving an key for that ("student")
	//and adding that object and setting an view for update.jsp file.
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam int id)
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("update.jsp");
		modelAndView.addObject("student",studentDao.findStudent(id));
		return modelAndView;
		
	}
	

	//when we click on submit after updating the data inside update.jsp
	//it will come and hit this method where we are updating the data 
	//inside the database using(studentDao.updateStudent(student)).
	//Then we setting an view for (view.jsp)
	//and adding an object of Object of List of students(studentsDao.findAllStudent())
	//with a key ("students")
	@RequestMapping("/saveUpdatedStudent")
	public ModelAndView saveUpdatedStudent(@ModelAttribute Student student)
	{
		ModelAndView modelAndView=new ModelAndView();
		studentDao.updateStudent(student);
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("students",studentDao.findAllStudents());
		return modelAndView;
	}
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id)
	{
		ModelAndView modelAndView=new ModelAndView();
		Student student=studentDao.findStudent(id);
		studentDao.deleteStudent(student);
		modelAndView.setViewName("view.jsp");
		modelAndView.addObject("students", studentDao.findAllStudents());
		return modelAndView;

	}
	
	
}
