package com.huawei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.xml.ws.WebServiceContext;  
import javax.xml.ws.handler.MessageContext;

import com.huawei.model.Person;
import com.huawei.service.IPersonService;

@Controller
@RequestMapping("/personController")
public class PersonController
{
	static Logger  logger = LoggerFactory.getLogger(PersonController.class);
	private IPersonService personService;
	
	@Resource 
	private WebServiceContext wsContext; 

	public IPersonService getPersonService()
	{
		return personService;
	}

	@Autowired
	public void setPersonService(IPersonService personService)
	{
		this.personService = personService;
	}

	@RequestMapping("/showPerson")
	public String showPersons(Model model, Person person)
	{
		
		// if(person.getName()!=null)
		// {
		// personService.insert(person);
		// }
		List<Person> persons = personService.loadPersons();
//		model.addAttribute("persons", persons);
//		System.out.println("客户端ip:"+getClientIpXfire());
		return "showperson";
	}

	@RequestMapping("/insert")
	public String addPerson(Person person)
	{
		personService.insert(person);
		return "showperson";
	}
	
	public String getClientIpXfire() {  
		MessageContext mc = wsContext.getMessageContext();  
		HttpServletRequest request = (HttpServletRequest)(mc.get(MessageContext.SERVLET_REQUEST));  
		String remortAddress = request.getRemoteAddr();  
		return (remortAddress); 
    }  
}