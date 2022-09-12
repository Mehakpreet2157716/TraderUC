package com.example.TraderUC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TraderUC.domain.Trader;

public interface TraderDAO extends JpaRepository<Trader, Long> {
	Trader findByEmail(String email);
}
