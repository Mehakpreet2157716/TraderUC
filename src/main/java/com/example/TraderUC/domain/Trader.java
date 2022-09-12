package com.example.TraderUC.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "trader")
public class Trader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	
	private String email;

	private int balance;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime cat;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime uat;

	public Trader() {
		super();

	}

	public Trader(int id, String name, String email, int balance, LocalDateTime cat, LocalDateTime uat) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.cat = cat;
		this.uat = uat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public LocalDateTime getCat() {
		return cat;
	}

	public void setCat(LocalDateTime cat) {
		this.cat = cat;
	}

	public LocalDateTime getUat() {
		return uat;
	}

	public void setUat(LocalDateTime uat) {
		this.uat = uat;
	}

	@Override
	public String toString() {
		return "Trader [id=" + id + ", name=" + name + ", email=" + email + ", balance=" + balance + ", cat=" + cat
				+ ", uat=" + uat + "]";
	}

}
