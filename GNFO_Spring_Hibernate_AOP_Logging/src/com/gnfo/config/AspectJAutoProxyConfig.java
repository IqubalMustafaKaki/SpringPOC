package com.gnfo.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.gnfo.aop.LoggingAspect;
import com.gnfo.dao.UserDAO;
import com.gnfo.dao.UserDAOImpl;

//@Configuration
//@EnableAspectJAutoProxy
public class AspectJAutoProxyConfig {
//  @Bean
//  public UserService userService(){
//	 return new UserService();
//  }
//  @Bean	
//  public LoggingAspect loggingAspect(){
//	 return new LoggingAspect();
//  }
//  
//	@Autowired
//	@Bean(name = "userDao")
//	public UserDAO getUserDao(SessionFactory sessionFactory) {
//	    return new UserDAOImpl(sessionFactory);
//	}
}