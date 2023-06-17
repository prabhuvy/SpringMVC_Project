package com.student.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.student"})
public class StudentConfig {
	//This is a Class for Configuration of our base packages
	
	//It is let Spring Know that those are the packages where 
	//we have our Component,Repository,Controller and we need spring 
	// to create Objects for them.

}
