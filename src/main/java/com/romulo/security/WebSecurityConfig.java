package com.romulo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("dev")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable().authorizeRequests().antMatchers("/users").hasRole("ADMIN")
				.anyRequest().authenticated().and().formLogin();
//		httpSecurity.csrf().disable().authorizeRequests()
//			.antMatchers("/home").permitAll()
//			.antMatchers(HttpMethod.POST, "/login").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			
//			// filtra requisições de login
//			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//	                UsernamePasswordAuthenticationFilter.class)
//			
//			// filtra outras requisições para verificar a presença do JWT no header
//			.addFilterBefore(new JWTAuthenticationFilter(),
//	                UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// cria uma conta default
		auth.inMemoryAuthentication().withUser("romulo").password("12345").roles("ADMIN");
	}
}
