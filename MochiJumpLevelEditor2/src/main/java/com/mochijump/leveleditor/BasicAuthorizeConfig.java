package com.mochijump.leveleditor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


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
        .authenticationEntryPoint(new NoPopAEPoint())
        .and()
        .authorizeRequests().antMatchers("/", "/mainmenu", "/runtime**",
        		"/polyfills**", "/favicon.ico", "/vendor**", "/styles**", 
        		"/main**", "/login", "/loginProcessor", "/test/activate**",
        		"/test/newUserCreation**", "/error", "/assets/**", "/test/returnAll",
        		"/test/version", "/test/message**", "/loginFailure").permitAll()
        //okay so anything you want to have locked must be a level deeper "/" gives permission to everything
        //on the first level apparently
        .antMatchers("/levelEditor").authenticated()
        .anyRequest().authenticated()        
        .and()
        .formLogin()
        .loginPage("/login")
        /*
        .failureHandler(new AuthenticationFailureHandler() {

			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				response.sendRedirect("/loginFailure");
				
			}
        	
        }) */
        .and()
        .logout();
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
    
    @Bean
    public AuthenticationEntryPoint noPopUpEntry() {
    	return new LoginUrlAuthenticationEntryPoint("/loginFailure");
    }
    
    public class NoPopAEPoint implements AuthenticationEntryPoint {

		@Override
		public void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException, ServletException {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		}
    }
    
   
    
}