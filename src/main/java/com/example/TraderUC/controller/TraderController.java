package com.example.TraderUC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TraderUC.dao.TraderDAO;
import com.example.TraderUC.service.TraderService;

import com.example.TraderUC.domain.Trader;

@RestController
@RequestMapping
public class TraderController {
	@Autowired
	private TraderDAO tdao;
	@Autowired
	private TraderService service;


	// get all the traders
	@GetMapping("/trading/traders/all")
	public List<Trader> getTraders() {
		// return list;
		return this.service.getTraders();
		
	}

	// get a specific trader using mail ID
	@GetMapping("/trading/traders")
	public ResponseEntity<Object> getTrader(@RequestParam("email") String emailID) {
		Trader trader = tdao.findByEmail(emailID);
		if (trader != null) {
			return new ResponseEntity<>(trader,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Create new trader
	@PostMapping("/trading/traders/register")
	public ResponseEntity<Object> addTrader(@RequestBody Trader t) {
		try {
			Trader result = tdao.save(t);
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Updating name of the trader
	@PutMapping("/trading/traders")
	public ResponseEntity<Object> updateName(@Validated @RequestBody Trader t) {
		Trader TempEmail = tdao.findByEmail(t.getEmail());
		if (TempEmail != null) {
			TempEmail.setName(t.getName());
			tdao.save(TempEmail);
			return new ResponseEntity<>(TempEmail, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Add money to the account
	@PutMapping("/trading/traders/add")
	public ResponseEntity<Object> addBal(@Validated @RequestBody Trader t) {
		Trader TempEmail = tdao.findByEmail(t.getEmail());
		if (TempEmail != null) {
			TempEmail.setBalance(t.getBalance() + TempEmail.getBalance());
			tdao.save(TempEmail);
			return new ResponseEntity<>(TempEmail, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}