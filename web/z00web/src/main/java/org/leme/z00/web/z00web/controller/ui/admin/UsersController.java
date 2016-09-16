package org.leme.z00.web.z00web.controller.ui.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController
{
  
  @RequestMapping(value="/ui/admin/users", method = RequestMethod.GET)
  public ModelAndView getUsersUi() {
    return new ModelAndView("/ui/admin/user");
  }    

}
