package org.leme.z00.web.z00web.controller.ui.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController
{
  @RequestMapping(value="/ui/common/menu", method = RequestMethod.GET)
  public ModelAndView getUsersUi() {
    return new ModelAndView("/ui/common/menu");
  }    
  

}
