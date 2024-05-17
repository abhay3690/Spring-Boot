package net.abhay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import net.abhay.security.CustomUserDetailService;
import net.abhay.security.JwtAuthenticationEntryPoint;
import net.abhay.security.JwtAuthenticationFilter;


@Configuration
@EnableWebSecurity

public class SecurityConfig {

	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired

	private JwtAuthenticationFilter jwtAuthenticationFilter;

//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
// 
//        http.csrf(csrf -> csrf.disable());
//        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/v1/auth/login").permitAll().anyRequest().authenticated());        
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.exceptionHandling(e -> e.authenticationEntryPoint(this.jwtAuthenticationEntryPoint));
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		
//		http.csrf(customizer -> customizer.disable());
//		System.out.println("H");
//		http.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());
//		System.out.println("He");
//		http.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint));
//		System.out.println("Hel");
//		http.httpBasic(Customizer.withDefaults());
//		System.out.println("Hell");
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		System.out.println("Hello");
//		 http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//		 System.out.println("Hellow");
//		return http.build();
//	}

//		@Bean
//		     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	
//		        http.csrf(csrf -> csrf.disable())
//		                .authorizeRequests().
//		                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll()
//		                .anyRequest()
//		                .authenticated()
//		                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//		                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
//		        return http.build();
//		    }
	@Bean
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("This is check purpose");
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("This is check purpose1");
		return new BCryptPasswordEncoder();
	}
}
