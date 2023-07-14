package com.gary.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gary.dojosandninjas.models.Dojo;
import com.gary.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepo;
	
	// Find All
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	
	// Find One
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}}
		
		//Create 
		public Dojo createDojo(Dojo newDojo) {
			return dojoRepo.save(newDojo);
		}
		
		// Update Expense
		public Dojo updateDojo(Dojo updatedDojo) {
			return dojoRepo.save(updatedDojo);
		}
		
		
		// Delete Expense
		public void deleteDojoById(Long id) {
			dojoRepo.deleteById(id);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

