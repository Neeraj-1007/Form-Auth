package com.neoSoft.formBasedAuthentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.neoSoft.formBasedAuthentication.model.User;
import com.neoSoft.formBasedAuthentication.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Autowired
	private CustomUserDetailsService customUserDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		without database
//		auth.inMemoryAuthentication().withUser("Neeraj").password(this.passwordEncoder().encode("neeraj")).roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("PoojaShree").password(this.passwordEncoder().encode("poojashree")).roles("LEAD");
//		with DataBase
		System.out.println(" inside configure method");
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http
				.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.and()
				.authorizeHttpRequests()
//				.antMatchers("/home","/login","/register").permitAll()
				.antMatchers("/signin","/abc","/public/logout","/public/home").permitAll()
				.antMatchers("/public/**","/api/v1/project/save","/api/v1/project/delete/{id}").hasRole("LEAD")
				.antMatchers("/users/**","/api/v1/student/save","/api/v1/student/delete/{id}").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
//				.httpBasic();
				.formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/dologin")
				.defaultSuccessUrl("/public/home");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	
}
