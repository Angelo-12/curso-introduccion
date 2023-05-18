package com.example.cuentas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cuentas.service.TicketService;

@RestController
@RequestMapping("/Tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public ResponseEntity<?> getTicket(@RequestParam String CreatedDate){
		return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicket(CreatedDate));
	}
}
