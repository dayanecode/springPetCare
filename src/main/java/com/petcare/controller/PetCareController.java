package com.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petcare.model.PetCare;
import com.petcare.repository.PetCareRepository;

@Controller
@RequestMapping("/")
public class PetCareController {
	
	
	@Autowired //Permite que o próprio Spring controle o repositório do Banco de Dados
	private PetCareRepository petcareRepository; //"Acordando" o meu Banco de Dados que está no representado no Repository
	
	
	@GetMapping("hello") 	//endpoint que será informado na URL
	public String hello(Model request) {
		request.addAttribute("nome", "PROTOCOLO");
		return "hello"; 	//busca na pasta templates uma página html criada com este nome ("hello").
	}
	
	
	@GetMapping("/listaDados") //Método que vai retornar as informações do banco de dados
	public String listaDados(Model request) {		
		List<PetCare> lista = petcareRepository.findAll(); //o List é o mesmo que um  Select * from SuaTabela definido pelo próprio  framework 
		request.addAttribute("listaDados", lista);
		return "listaDados";
	}
	

}
