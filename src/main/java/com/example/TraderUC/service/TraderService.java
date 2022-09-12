package com.example.TraderUC.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.TraderUC.domain.Trader;

public interface TraderService {
	public List<Trader> getTraders();

	public ResponseEntity<Object> getTrader(String emailID);

	public ResponseEntity<Object> addTrader(Trader t);

	public ResponseEntity<Object> updateName(Trader t);

	public ResponseEntity<Object> addBal(Trader t);
}