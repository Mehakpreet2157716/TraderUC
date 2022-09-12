package com.example.TraderUC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.TraderUC.dao.TraderDAO;
import com.example.TraderUC.domain.Trader;

@Service
public class TraderServiceImpl implements TraderService {
	@Autowired
	private TraderDAO tdao;
	public TraderServiceImpl() {

	}


	//Get all traders
	@Override
	public List<Trader> getTraders() {
		// return list;
		return tdao.findAll();
	}



	@Override
	public ResponseEntity<Object> getTrader(@PathVariable(value = "email") String emailID) {
		Trader trader = tdao.findByEmail(emailID);
		if (trader == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(trader, HttpStatus.OK);
		}


	}

	@Override
	public ResponseEntity<Object> addTrader(Trader t) {
		try {
			Trader result = tdao.save(t);
			return new ResponseEntity<>( result,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Object> updateName(Trader t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> addBal(Trader t) {
		// TODO Auto-generated method stub
		return null;
	}

}




