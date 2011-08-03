package org.pan.freelancer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

//imports
@Controller
@RequestMapping("/displaytag.do")
public class DisplaytagController {

  private static List<User> userList;

  static {
      userList = new ArrayList<User>(20);
      userList.add(new User(1, "Gaurav Arora", "gaurav@myemail.com", "+91-98119-09880"));
      userList.add(new User(2, "Bernard Shaw", "bernard@myemail.com", "+91-92119-09880"));
      userList.add(new User(3, "Aurora Aurealis", "aurora@myemail.com", "+91-93119-09880"));
      userList.add(new User(4, "James Lock", "james@myemail.com", "+91-98114-09880"));
      userList.add(new User(5, "Karl love", "karl@myemail.com", "+91-98169-09880"));
      userList.add(new User(6, "George jungle", "george@myemail.com", "+91-98819-09880"));
      userList.add(new User(7, "Switch blade", "switch@myemail.com", "+91-98118-09880"));
      userList.add(new User(8, "Gold flake", "gold@myemail.com", "+91-98119-09380"));
      userList.add(new User(9, "Susan Anthony", "susan@myemail.com", "+91-98113-09880"));
      userList.add(new User(10, "Arm Guard", "armg@myemail.com", "+91-98119-02880"));
      userList.add(new User(11, "Raju Gentleman", "raju@myemail.com", "+91-98319-09880"));
      userList.add(new User(12, "Rajat Ghandhi", "rajat@myemail.com", "+91-98519-09880"));
      userList.add(new User(13, "Niketa Shyam", "niketa@myemail.com", "+91-98719-09880"));
      userList.add(new User(14, "G. Mahesh", "mahesh@myemail.com", "+91-98118-09880"));
      userList.add(new User(15, "Yogvinder Singh", "yogi@myemail.com", "+91-99119-09880"));
      userList.add(new User(16, "Eklavya", "eklavya@myemail.com", "+91-98119-00880"));
      userList.add(new User(17, "Asus shyam", "asus@myemail.com", "+91-98119-09680"));
      userList.add(new User(18, "Jack donneley", "jack@myemail.com", "+91-98119-01880"));
      userList.add(new User(19, "Donald McDonald", "donald@myemail.com", "+91-98119-03880"));
      userList.add(new User(20, "Azure Aloha", "azure@myemail.com", "+91-98119-09890"));
  }

  @RequestMapping(method = RequestMethod.GET)
  public String showPage(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
      Map paramMap = WebUtils.getParametersStartingWith(request, "d-");
      if (paramMap.size() == 0) {
          //WebUtils.setSessionAttribute(request, "userList", userList);
    	  modelMap.addAttribute("userList", userList);
      }
      modelMap.addAttribute("size", 28);
      return "displaytag";
  }
}
