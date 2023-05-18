package com.example.cuentas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cuentas.model.Pais;
import com.example.cuentas.model.Ticket;

public interface TicketRespository extends JpaRepository<Ticket, Long>{
	
	@Query(value = "select * from ticket where fecha_creacion=?",nativeQuery = true)
	Ticket getTicket(@Param("CreatedDate") String date);
}
