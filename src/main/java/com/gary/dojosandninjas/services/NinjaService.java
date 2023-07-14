package com.gary.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gary.dojosandninjas.models.Ninja;
import com.gary.dojosandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;

	// Find All
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	
	// Create Ninja
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	
	// Find one 
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	
	// Update Expense
	public Ninja updateNinja(Ninja updatedNinja) {
		return ninjaRepo.save(updatedNinja);
	}
	
	
	// Delete Expense
	public void deleteNinjaById(Long id) {
		ninjaRepo.deleteById(id);
	}
	
	
}
