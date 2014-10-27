/* CustomerController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Hilo;
import domain.User;
import services.ThreadService;
import services.UserService;


@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController {
	
	@Autowired ThreadService threadService;
	@Autowired UserService userService;
	
	
	// Constructors -----------------------------------------------------------

	public CustomerController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------		

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("customer/action-1");

		return result;
	}
	
	// Action-2 ---------------------------------------------------------------		

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("customer/action-2");

		return result;
	}
	
	
	
	@RequestMapping("/listThreads")
	public ModelAndView prueba(){
		
		
		ModelAndView result;
		
		Collection<domain.Hilo> threads;
		threads=threadService.findAll();
		
		
		result=new ModelAndView("customer/listThreads");
		result.addObject("threads",threads);
		return result;
		
		
	}
	
	
	@RequestMapping("/seeThread")
	public ModelAndView seeThread(@RequestParam int id){
		
		
	Hilo hilo=threadService.findOne(id);
	ModelAndView result =new ModelAndView("customer/seeThread");
	result.addObject("hilo",hilo);
	result.addObject("comments",hilo.getComments());
	
	return result;
		
		
		
	}

	
	
	@RequestMapping("/createThread")
	public ModelAndView createThread(){
		
		
		ModelAndView result=createEditModelAndView(new domain.Hilo());
		
		return result;
		
		
		
		
	}
	
	private ModelAndView createEditModelAndView(domain.Hilo thread){
		
		
		return createEditModelAndView(thread, null);
	}
	
	private ModelAndView createEditModelAndView(domain.Hilo thread, String message){
		
		
		ModelAndView result;
		
		
		if(thread.getUser()==null){//NUEVO
			
			thread.setUser(userService.findByPrincipal());
			result=new ModelAndView("customer/createNewThread");
			result.addObject("user", thread.getUser());
			result.addObject("thread", thread);			
			
		}else{
			
			
			User user=thread.getUser();
			
			result=new ModelAndView("customer/editThread");
			
			result.addObject("thread", thread);
			result.addObject("user", user);
			
			
			
		}
		
		
		return result;
		
		
		
		
		
	}
	


	
	
	
	
}