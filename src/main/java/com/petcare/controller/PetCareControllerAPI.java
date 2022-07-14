package com.petcare.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.model.PetCare;
import com.petcare.repository.PetCareRepository;

@RestController
@RequestMapping("/petcare")
public class PetCareControllerAPI {
	
	@Autowired
	private PetCareRepository petcareRepository;
	
	@GetMapping("/health")
	public String health() {
		return "Application is ON";
	}
	
	@PostMapping
	public PetCare adicionar(@RequestBody PetCare petcare) {
		return petcareRepository.save(petcare);
	}
	
	@GetMapping
	public List<PetCare> listar () {
		return petcareRepository.findAll();
	}
		
	@GetMapping ("/id")
	public ResponseEntity<PetCare> buscar(@PathVariable Long id) {
		
		PetCare petcare = petcareRepository.getById(id);
		
		if (petcare == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(petcare);
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<PetCare> atualizar(@PathVariable Long id, 
			@RequestBody PetCare petcare) {
		PetCare existente = petcareRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
	
		BeanUtils.copyProperties(petcare, existente, "id");
		existente = petcareRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		PetCare petcare = petcareRepository.getById(id);
		
		if (petcare == null) {
			return ResponseEntity.notFound().build();
		}
		petcareRepository.delete(petcare);
		return ResponseEntity.noContent().build();
	}

	

	

}
