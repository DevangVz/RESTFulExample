package org.biblioteca.control;

import org.biblioteca.dao.AuthorDAO;
import org.biblioteca.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/authors")
public class AuthorController {
	
	@Autowired
	AuthorDAO authorDAO;
		
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String modifying(){
		
		return "";
	}
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public int save(@ModelAttribute("author") Author author){  
		return authorDAO.save(author);  
        
    }  
}
