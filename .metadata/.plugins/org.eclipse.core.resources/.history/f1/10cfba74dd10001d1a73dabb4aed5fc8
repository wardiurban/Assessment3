package com.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bean.Login;
import com.service.LoginService;
@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "checkLoginDetails",method = RequestMethod.POST)
	public ModelAndView signIn(HttpServletRequest req, Login ll) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String typeOfUser = req.getParameter("typeOfUser");
		
		ModelAndView mav = new ModelAndView();
		
		if(typeOfUser.equals("admin")) {
			
			String result = loginService.checkAdminLogin(ll);
			if(result.equals("success")) {
				mav.setViewName("adminHome.jsp");
			}else {
				mav.setViewName("failure.jsp");
			}
			
		}else {
		
			ll.setEmail(email);
			ll.setPassword(password);
			
			String result = loginService.signIn(ll);
		
			if(result.equals("success")) {
					mav.setViewName("userHome.jsp");
			}else {			
				mav.setViewName("failure.jsp");
			}
			
		}
		
		return mav;
	}
	
	@RequestMapping(value = "storeLoginDetails",method=RequestMethod.POST)
	public ModelAndView signUp(HttpServletRequest req,Login ll) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		ll.setEmail(email);
		ll.setPassword(password);
		
		String result = loginService.signUp(ll);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		mav.addObject("msg", result);
		return mav;
	}
}
