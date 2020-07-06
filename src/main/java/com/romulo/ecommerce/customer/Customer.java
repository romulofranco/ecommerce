package com.romulo.ecommerce.customer;

import javax.persistence.Entity;

import com.romulo.ecommerce.data.BaseEntity;

@Entity
public class Customer extends BaseEntity {

    private String name;
    private String email;

    public Customer() {
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
    
    
}
