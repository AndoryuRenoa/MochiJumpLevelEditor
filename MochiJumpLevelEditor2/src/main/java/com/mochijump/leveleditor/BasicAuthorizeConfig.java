package com.mochijump.leveleditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
 class BasicAuthorizeConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .httpBasic()
        .and()
        .authorizeRequests().antMatchers("/", "/mainmenu", "/runtime**",
        		"/polyfills**", "/favicon.ico", "/vendor**", "/styles**", 
        		"/main**", "/login", "/loginProcessor", "/test/activate**",
        		"/test/newUserCreation**", "/error", "/images/**").permitAll()
        //okay so anything you want to have locked must be a level deeper "/" gives permission to everything
        //on the first level apparently
        .antMatchers("/levelEditor").authenticated()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login");
        /*
        .usernameParameter("username")
        .passwordParameter("password")
        .defaultSuccessUrl("/mainmenu")
        .failureUrl("/login")
        .and()
        
        .logout();
        */
    }
/*    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
    }
  */  
    @Override
    protected void configure (AuthenticationManagerBuilder auth) {
    	auth.authenticationProvider(authenticationProvider());
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    	authProvider.setUserDetailsService(userDetailsService);
    	authProvider.setPasswordEncoder(encoder());
    	return authProvider;
    }
    
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }
   
    
}