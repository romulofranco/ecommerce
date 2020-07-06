package com.uni7.ecommerce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.romulo.ecommerce.customer.Customer;

@RunWith(SpringRunner.class)
public class CustomerTest {
	private String nome;
	private String email;

	@Before
	public void Init() {
		nome = "Fulano Franco";
		email = "fulano@gmail.com";
	}

	@Test
	public void deve_criar_um_cliente_com_nome() {
		Customer customer = new Customer();
		customer.setName(nome);
		customer.setEmail(email);
		Assert.assertEquals(nome, customer.getName());
	}	
	
}