package com.example.cuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuentas.service.CuentaService;
import com.example.cuentas.service.PaisService;

@RestController
@RequestMapping("/Paises")
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	@GetMapping
	public ResponseEntity<?> getPais(@RequestParam String nombre){
		return ResponseEntity.status(HttpStatus.OK).body(paisService.getPais(nombre));	
	}
}
