package org.leme.z00.web.z00web.controller.data;

import java.util.List;

import org.leme.z00.components.domain.Z00CustomException;
import org.leme.z00.components.domain.user.User;
import org.leme.z00.components.service.membership.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/data/user")
public class UserController {

  @Autowired
  private UserDataService userDataService; 
  

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public @ResponseBody User getUserById(@PathVariable Integer id) {
    return userDataService.loadById(id);
  }  
  
  @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
  public @ResponseBody boolean deleteUserById(@PathVariable Integer id) {
    try{
      User u = userDataService.loadById(id);
      userDataService.delete(u);
    }catch(Exception s){
      return false;
    }
    return true;
  }     
  
  @RequestMapping(value="", method = RequestMethod.POST)
  public @ResponseBody User saveUser(@RequestParam("name") String name, @RequestParam("firstName") String firstName, 
      @RequestParam("lastName") String lastName, @RequestParam("email") String email, @RequestParam("password") String password) throws Z00CustomException {
    User user = userDataService.findByName(name);
    if(user == null){
      user = new User();
      user.setName(name);
    }    
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setEmail(email);    
    user = userDataService.save(user);
    userDataService.updatePassword(user, password, false);
    return user;
  }  

  @RequestMapping(value="/{id}/password", method = RequestMethod.POST)
  public @ResponseBody boolean deleteUserById(@PathVariable Integer id, @RequestParam("password") String password, @RequestParam("temp") Boolean temp) {
    try{
      User u = userDataService.loadById(id);
      userDataService.updatePassword(u, password, temp);
      userDataService.delete(u);
    }catch(Exception s){
      return false;
    }
    return true;
  }    
  
  @RequestMapping(value="/byName/{name}", method = RequestMethod.GET)
  public @ResponseBody User getUserByName(@PathVariable String name) {
    return userDataService.findByName(name);
  } 
  
  public static class Recordset {
    
    public List<User> rows;
    
    public Recordset(List<User> rows)
    {
      super();
      this.rows = rows;
    }

    public void setRow(List<User> rows)
    {
      this.rows = rows;
    }

  }
  
  
  @RequestMapping(value="/users", method = {RequestMethod.GET,RequestMethod.POST}) 
  public @ResponseBody Recordset getAll() {
    return new Recordset (userDataService.getAllUsers());
  }
  
 

  
}
