package com.adwait.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class FormAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Caleb22").password("{noop}dd").roles("USER", "EMPLOYEE").and()
				.withUser("Dylan123").password("{noop}jj").roles("MANAGER").and().withUser("Sean1")
				.password("{noop}sean").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/student").hasRole("EMPLOYEE")
				.antMatchers("/student/showFormForAdd/**", "/student/addAddress/**").hasRole("ADMIN")
				.antMatchers("/student/addAddress/**").hasRole("MANAGER").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser").defaultSuccessUrl("/student/list").permitAll().and()
				.logout().logoutSuccessUrl("/login").permitAll().and().exceptionHandling()
				.accessDeniedPage("/access-denied");
		http.authorizeRequests().anyRequest().authenticated();

	}
}
