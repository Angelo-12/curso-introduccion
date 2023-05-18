package com.example.cuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuentas.service.PokemonService;

@RestController
@RequestMapping("Pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/{pokemon}/abilities")
	public ResponseEntity<Object> getAbilitiesPokemon(@PathVariable String pokemon){
		return ResponseEntity.ok(pokemonService.getAbilitiesPokemon(pokemon));
	}
	@GetMapping("/{pokemon}/base-experiences")
	public ResponseEntity<Object> getBaseExperiences(@PathVariable String pokemon){
		return ResponseEntity.ok(pokemonService.getBaseExperiencesPokemon(pokemon));
	}
	
	@GetMapping("/{pokemon}/held-items")
	public ResponseEntity<Object> getHeldItems(@PathVariable String pokemon){
		return ResponseEntity.ok(pokemonService.getHeldItems(pokemon));
	}
	
	@GetMapping("/{pokemon}/id")
	public ResponseEntity<Object> getId(@PathVariable String pokemon){
		return ResponseEntity.ok(pokemonService.getId(pokemon));
	}

	@GetMapping("/{pokemon}/name")
	public ResponseEntity<Object> getName(@PathVariable String pokemon){
		return ResponseEntity.ok(pokemonService.getName(pokemon));
	}
	
	@GetMapping("/{pokemon}/location-area-encounters")
	public ResponseEntity<Object> getLocationAreaEncounters(@PathVariable String pokemon){
		return ResponseEntity.ok(pokemonService.getLocationAreaEncounters(pokemon));
	}
}
