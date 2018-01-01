package com.huawei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huawei.model.Person;
import com.huawei.service.IPersonService;

@Controller
@RequestMapping("/personController")
public class PersonController {
    
    private IPersonService personService;
    
    public IPersonService getPersonService() {
        return personService;
    }

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/showPerson")
    public String showPersons(Model model,Person person){
//    	if(person.getName()!=null)
//    	{
//    		personService.insert(person);
//    	}  	
        List<Person> persons = personService.loadPersons();  
        model.addAttribute("persons", persons);
        return "showperson";
    }
    
    @RequestMapping("/insert")
    public String addPerson(Person person){
    	personService.insert(person);
        return "showperson";
    }
}