package com.adwait.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.adwait.repository.UserRepository;
import com.adwait.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class FormAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceBean()).passwordEncoder(getPasswordEncoder());
	}

	@Bean
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return new CustomUserDetailsService();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/student").hasRole("EMPLOYEE")
				.antMatchers("/student/showFormForAdd/**", "/student/addAddress/**").hasRole("ADMIN")
				.antMatchers("/student/addAddress/**").hasRole("MANAGER").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().logoutSuccessUrl("/login")
				.permitAll().and().exceptionHandling().accessDeniedPage("/access-denied");
		http.authorizeRequests().anyRequest().authenticated();

	}

	private PasswordEncoder getPasswordEncoder() {

		return new PasswordEncoder() {

			@Override

			public String encode(CharSequence charSequence) {

				return charSequence.toString();

			}

			@Override

			public boolean matches(CharSequence charSequence, String s) {

				return true;

			}

		};

	}

}
