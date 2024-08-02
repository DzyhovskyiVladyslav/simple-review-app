package com.springcourseraproject.simplereviewapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="review")
public class Review {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name", nullable=false)
	private String name;
    
    @Column(name="email", nullable=false)
	private String email;
    
    @Column(name="product", nullable=false)
	private String product;
    
    @Column(name="rate", nullable=false)
	private int rate;
    
    @Column(name="comment", nullable=false)
	private String comment;
	
	public Review() {
		super();
	}
	
	public Review(String name, String email, String product, int rate, String comment) {
		super();
		this.name = name;
		this.email = email;
		this.product = product;
		this.rate = rate;
		this.comment = comment;
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
	
	public String getProduct() {
		return product;
	}
	
	public void setProduct(String product) {
		this.product = product;
	}
	
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Review [name=" + name + ", email=" + email + ", product=" + product + ", rate=" + rate + ", comment=" + comment + "]";
	}
}