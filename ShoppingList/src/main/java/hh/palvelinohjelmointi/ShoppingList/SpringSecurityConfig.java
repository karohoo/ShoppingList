package hh.palvelinohjelmointi.ShoppingList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.palvelinohjelmointi.ShoppingList.web.UserDetailServiceImpl;
import hh.palvelinohjelmointi.ShoppingList.domain.*;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	private UserRepository urepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.authorizeRequests().antMatchers("/css/**").permitAll()
        .and()
        .authorizeRequests()
		.antMatchers("/shoppinglist", "/additem", "/save").permitAll()
		.antMatchers("/delete/{id}", "/edititem/{id}").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/shoppinglist")
		.permitAll()
		.and()
		.logout()
		.permitAll();
	}
	
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
}
