package com.javahorn.controller;

import com.javahorn.beans.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class TestController {
  @RequestMapping(value = "/helloWorld.web", method = RequestMethod.GET)
  public ModelAndView printWelcome(@ModelAttribute("user") Users user) {
    ModelAndView mav = new ModelAndView("lazyRowLoad");
    mav.addObject("message", "Hello World!!!");
    return mav;
  }

  @RequestMapping(value = "/lazyRowAdd.web", method = RequestMethod.POST)
  public ModelAndView lazyRowAdd(@ModelAttribute("user") Users user) {
    Users users = new Users();
    ModelAndView mav = new ModelAndView("lazyRowLoad");
    mav.addObject("users", users);
    System.out.println(Arrays.toString(user.getOperationParameterses().toArray()));
    return mav;
  }
}
