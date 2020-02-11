package com.sai;



import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sai.dao.EmployeeDao;


@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class SpringBootJdbcApp1Application {
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(SpringBootJdbcApp1Application.class, args);
	    EmployeeDao employeeDao = (EmployeeDao)applicationContext.getBean("employeeDao");
	    employeeDao.createEmployee("springemp","desg1");
	}

}
