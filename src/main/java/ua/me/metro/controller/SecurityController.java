package ua.me.metro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String loginPageReDirect(){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginFailure", method = RequestMethod.GET)
    public String loginFailurePage(ModelMap modelMap){
        modelMap.addAttribute("error","true");
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
      public String logoutPage(ModelMap modelMap){
        modelMap.addAttribute("success","true");
        return "login";
    }
    @RequestMapping(value="/errAuth", method = RequestMethod.GET)
    public String errAuthPage(){
        return "errAuth";
    }
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }





		
}
