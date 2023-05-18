package com.example.cuentas.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuentas.model.Cuenta;
import com.example.cuentas.service.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	
	@Autowired
	private CuentaService cuentaService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	private ResponseEntity<List<Cuenta>> getAll(){
		return ResponseEntity.ok(cuentaService.findAll());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	private ResponseEntity<Optional> getById(@PathVariable("id") Long id){
		return ResponseEntity.ok(cuentaService.findById(id));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	private ResponseEntity<Cuenta> saveCuenta(@RequestBody Cuenta cuenta){
		
		try {
			Cuenta nuevaCuenta = cuentaService.save(cuenta);
			return ResponseEntity.created(new URI("/cuentas/"+nuevaCuenta.getIdCuenta())).body(nuevaCuenta);
		} catch (URISyntaxException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	private ResponseEntity<Boolean> deleteCuenta(@PathVariable("id") Long id){
		cuentaService.deleteById(id);
		return ResponseEntity.ok((cuentaService.findById(id)!=null));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
	private ResponseEntity<Cuenta> updateCuenta(@PathVariable("id") Long id,@RequestBody Cuenta cuentaNueva){
		Cuenta cuentaActualizada = cuentaService.getById(id);
		cuentaActualizada.setNumeroCuenta(cuentaNueva.getNumeroCuenta());
		cuentaActualizada.setSaldo(cuentaNueva.getSaldo());
		cuentaService.save(cuentaActualizada);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
