package net.abhay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.RequiredArgsConstructor;
import net.abhay.security.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {
	public static final String[] PUBLIC_URLS = { "/api/v1/auth/**", "/v3/api-docs/**", "/swagger-resources/**", "swagger-ui/**", "/webjars/**" };

	private final JWTAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().requestMatchers(PUBLIC_URLS).permitAll()
//		.requestMatchers("/api/v1/auth/**").permitAll()
//		.requestMatchers("/v3/api-docs").permitAll()
//		.requestMatchers(HttpMethod.GET).permitAll()
				.anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}