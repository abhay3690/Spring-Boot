package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 final String authHeader = request.getHeader("Authorization");
	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	            String token = authHeader.substring(7);
	            String userEmail = jwtService.getUsernameFromToken(token);
	            if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	                UserDetails userDetails = userDetailsService.loadUserByUsername(userEmail);
	                if (jwtService.isTokenValid(token, userDetails)) {
	                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
	                            userDetails, null, userDetails.getAuthorities());
	                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	                }
	            }
	        }
	        filterChain.doFilter(request, response);		
	}
}




//package com.security;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.annotation.Nonnull;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//
//@Component
//@RequiredArgsConstructor
//public class JWTAuthenticationFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtService jwtService;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Override
//	protected void doFilterInternal(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response,
//			@Nonnull FilterChain filterChain) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		final String authHeader = request.getHeader("Authorization");
//		final String token;
//		final String userEmail;
//
//		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		token = authHeader.substring(7);
//		userEmail = jwtService.getUsernameFromToken(token);
////		userEmail = jwtService.extractUsername(token);
//		if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//
//			if (jwtService.isTokenValid(token, userDetails)) {
//				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//						userEmail, null, userDetails.getAuthorities());
//
//				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//			}
//		}
//		filterChain.doFilter(request, response);
//	}
//
//}