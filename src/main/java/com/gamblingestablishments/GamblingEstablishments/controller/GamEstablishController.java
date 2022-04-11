package com.gamblingestablishments.GamblingEstablishments.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.gamblingestablishments.GamblingEstablishments.model.Establishment;
import com.gamblingestablishments.GamblingEstablishments.services.EstablishmentServices;

@RestController
@RequestMapping("/api")
public class GamEstablishController {

	@Autowired
	private EstablishmentServices establishmentServices;

	// Get method
	// ----------------------------------------------------------------------------
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Establishment> getEstablishmentById(@PathVariable int id) {
		Establishment establishment = establishmentServices.getEstablishmentById(id);
		return new ResponseEntity<Establishment>(establishment, HttpStatus.OK);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Establishment> getEstablishmentList() {
		return establishmentServices.getEstablishments();
	}

	// Create method
	// ----------------------------------------------------------------------------
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Establishment> createEstablishment(@RequestBody @Valid Establishment estParam) {
		establishmentServices.createEstablishment(estParam);
		return new ResponseEntity<Establishment>(HttpStatus.CREATED);
	}

	// Delete method
	// -----------------------------------------------------------------------------
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Establishment> deleteEstablishmentById(@PathVariable int id) {
		establishmentServices.deleteEstablishmentById(id);
		return new ResponseEntity<Establishment>(HttpStatus.OK);
	}
}
