package com.example.cuentas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PokemonService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	@Value("${app.external.service.url-pokemon}")
	private String url;
	
	@GetMapping("/{pokemon}/abilities")
	public Object getAbilitiesPokemon(@PathVariable ("pokemon") String pokemon) {
		return getData(pokemon).get("abilities");
	}
	
	@GetMapping("/{pokemon}/base-experiences")
	public Object getBaseExperiencesPokemon(@PathVariable ("pokemon") String pokemon) {
		return getData(pokemon).get("base_experience");
	}

	@GetMapping("/{pokemon}/held-items")
	public Object getHeldItems(@PathVariable ("pokemon") String pokemon) {
		return getData(pokemon).get("held_items");
	}
	
	@GetMapping("/{pokemon}/id")
	public Object getId(@PathVariable ("pokemon") String pokemon) {
		return getData(pokemon).get("id");
	}
	
	@GetMapping("/{pokemon}/name")
	public Object getName(@PathVariable ("pokemon") String pokemon) {
		return getData(pokemon).get("name");
	}
	@GetMapping("/{pokemon}/location-area-encounters")
	public Object getLocationAreaEncounters(@PathVariable ("pokemon") String pokemon) {
		return getData(pokemon).get("location_area_encounters");
	}
	
	private JsonNode getData(String pokemon) {
		String path = restTemplate.exchange(url+pokemon, HttpMethod.GET,null,String.class).getBody();
		try {
			return objectMapper.readTree(path);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return null;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
