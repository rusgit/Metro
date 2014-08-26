package ua.me.metro.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.me.metro.domain.ListRole;
import ua.me.metro.domain.User;
import ua.me.metro.domain.UserRole;
import ua.me.metro.service.IUserService;
import ua.me.metro.util.HelperEncode;


import java.util.HashSet;
import java.util.Set;

@Controller
public class RegController {

	@Inject
    IUserService userService;
    @Inject
    HelperEncode helperEncode;


	@RequestMapping(value="/reg", method = RequestMethod.GET)
	public ModelAndView reg() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("reg");
		return modelAndView;
	}

    @RequestMapping(value="/reg/submit", method = RequestMethod.GET)
    public String regSubmitRedirect() {
        return "redirect:/reg";
    }

	@RequestMapping(value="/reg/submit", method = RequestMethod.POST)
	public ModelAndView regSubmit(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("passwordRepeat") String passwordRepeat,
                                  @RequestParam("email") String email) {
		
		ModelAndView modelAndView = new ModelAndView();
////////////////////////////////////////////////////////////////////////
		if (username.length()<5 || password.length()<5) {
			
			modelAndView.addObject("exception", "Login and Password must be more then 5 symbols");
			modelAndView.setViewName("reg");
			return modelAndView;
		} 
		if (!password.equals(passwordRepeat)) {
			
			modelAndView.addObject("exception", "Password and repeat of Password is not equals");
			modelAndView.setViewName("reg");
			return modelAndView;
		}	
////////////////////////////////////////////////////////////////////////		
				
		User user = userService.getUserByUsername(username);
				
		if (user==null) {

            UserRole userRole = new UserRole(1,ListRole.ROLE_USER);
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(userRole);
			user = new User(null, username, helperEncode.encode(password), email, userRoles);

            if(userService.addUser(user)) {
                modelAndView.addObject("goodLogin", "Registration Successful. Enter Your Username and Password");
                modelAndView.setViewName("login");
                return modelAndView;

            } else {
                modelAndView.addObject("exception", "Error add user");
                modelAndView.setViewName("reg");
                return modelAndView;
            }

		} else {
			modelAndView.addObject("exception", "User with enter login is already exists");
			modelAndView.setViewName("reg");
			return modelAndView;
		}				
	}	
}

