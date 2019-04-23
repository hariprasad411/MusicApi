/*
 * Copyright 2018 Hari Prasad Ghanta
 * 
 * Created on : 20-04-19
 * Author     : Hari Prasad Ghanta
 *
 *-----------------------------------------------------------------------------
 * Revision History (Release 1.0.0.0)
 *-----------------------------------------------------------------------------
 * VERSION     AUTHOR/      DESCRIPTION OF CHANGE
 * OLD/NEW     DATE                RFC NO
 *-----------------------------------------------------------------------------
 * --/1.0  | author        | Initial Create.
 *         | 20-04-19      |
 *---------|---------------|---------------------------------------------------
 *         | author        | Defect ID 1/Description
 *         | dd-mm-yy      | 
 *---------|---------------|---------------------------------------------------
 */
package com.music.album.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
        		.and()
          .withUser("admin").password("{noop}password").roles("USER","ADMIN");
    }
    
    //Securing the EndPoints with Basic HTTP Authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
        .antMatchers(HttpMethod.GET,"/itunes/music/albums/updateDataBase").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET,"/itunes/music/albums/p**").hasRole("USER")
        .antMatchers(HttpMethod.GET,"/itunes/music/albums").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST,"/itunes/music/albums").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT,"/itunes/music/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PATCH,"/itunes/music/albums/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE,"/itunes/music/**").hasRole("ADMIN")
        .and()
        .csrf().disable()
        .formLogin().disable();
    }
    
    /**
     * Temporarily creating username and password in memory for localDemo
     */
    @Bean
    public UserDetailsService userDetailsService(){
    	@SuppressWarnings("deprecation")
		User.UserBuilder users = User.withDefaultPasswordEncoder();
    	
    	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    	manager.createUser(users.username("user").password("password").roles("USER").build());
    	manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
		return manager;
    	
    	
    	
    }
}