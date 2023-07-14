package com.gary.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gary.dojosandninjas.models.Dojo;
import com.gary.dojosandninjas.models.Ninja;
import com.gary.dojosandninjas.services.DojoService;
import com.gary.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;







@Controller
public class MainController {
	
	
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	
	
	//Create Dojo
	//Render form
	@GetMapping("/dojos/new")
	public String renderDojoForm(@ModelAttribute("newDojo") Dojo newDojo) {
		return "CreateDojo.jsp";
	}
	
	//Create Dojo
	// process form
	@PostMapping("/dojos/create")
	public String processDojoForm(
			@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "CreateDojo.jsp";
		} else {
			dojoService.createDojo(newDojo);
			return "CreateDojo.jsp";
		}
	}
//	
	
	
	
	// Rendering form to Create Ninja
	@GetMapping("/ninjas/new")
	public String renderCreateNinjaForm(Model model) {
		model.addAttribute("newNinja", new Ninja());
		
		// to pick dojo (dont need this after log-reg)
		model.addAttribute("dojoList", dojoService.allDojos());
		return "CreateNinja.jsp";
	}
	
	
	//  Create Ninja   - Post data to database
	@PostMapping("/ninjas/create")
	public String processNinjaForm(
			@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result) {
		if(result.hasErrors()) {
			return "CreateNinja.jsp";
		} else {
			Ninja ninja = ninjaService.createNinja(newNinja);
			
			return "redirect:/dojos/"+ ninja.getOwner().getId();
		}
	}
	
	// Rendering Details for one Dojo
	@GetMapping("/dojos/{id}")
	public String dojoDetails(@PathVariable("id")Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
		return "dojoDetails.jsp";
	}
	
//	Ninja Details
	// Rendering Details for one Ninja
	@GetMapping("/ninjas/{id}")
	public String ninjaDetails(@PathVariable("id")Long id, Model model) {
		model.addAttribute("ninja", ninjaService.oneNinja(id));
		return "ninjaDetails.jsp";
	}
	
	
	
	// Edit
	// Render the form
	@GetMapping("/ninjas/{id}/edit")
	public String renderEditNinja(@PathVariable("id")Long id, Model model) {
		model.addAttribute("ninja", ninjaService.oneNinja(id));
		return "editNinja.jsp";
	}
	
	// Process the form
	@PutMapping("/ninjas/{id}/edit")
	public String processEditNinja(@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editNinja.jsp";
		} else {
			Ninja updatedNinja = ninjaService.updateNinja(ninja);
			return "redirect:/dojos/"+ updatedNinja.getOwner().getId();
		}
	}
	
}
