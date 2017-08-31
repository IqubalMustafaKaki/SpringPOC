package com.gnfo.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gnfo.dao.UserDAO;
import com.gnfo.model.User;

/**
 * @author Iqubal Mustafa Kaki
 * Handles REST WS requests for the application.
 */
//@Scope("session")
@RestController
public class RestWSUserController {
     
    @Autowired
    private UserDAO userDao;
 
    // URL : http://localhost:8080/GNFO_Spring_Hibernate_AOP/restWS
    @RequestMapping("/restWS")
    public List<User> handleRequest() throws Exception {
        List<User> listUsers = userDao.list();
        return listUsers;
    }
     
    // URL : http://localhost:8080/GNFO_Spring_Hibernate_AOP/restEdit/{id}
    @RequestMapping(value = "/restEdit/{id}", method = RequestMethod.GET)
    public User editUser(@PathVariable String id){
        int userId = Integer.parseInt(id);
        User user = userDao.get(userId);
        return user;      
    }
    
    // URL : http://localhost:8080/GNFO_Spring_Hibernate_AOP/restDelete/{id}
    @RequestMapping(value = "/restDelete/{id}", method = RequestMethod.GET)
    public List<User> deleteUser(@PathVariable String id) {
        int userId = Integer.parseInt(id);
        userDao.delete(userId);
        List<User> listUsers = userDao.list();
        return listUsers;  
    }
    
    // URL : http://localhost:8080/GNFO_Spring_Hibernate_AOP/restSave
    @RequestMapping(value = "/restSave", method = RequestMethod.GET)
    public  List<User> saveUser(@QueryParam("userName") String userName, @QueryParam("userEmail") String userEmail, @QueryParam("userPass") String userPass) {
        User user = new User();
        user.setUsername(userName);
        user.setEmail(userEmail);
        user.setPassword(userPass);
    	userDao.saveOrUpdate(user);
        List<User> listUsers = userDao.list();
        return listUsers;
    }
    
}