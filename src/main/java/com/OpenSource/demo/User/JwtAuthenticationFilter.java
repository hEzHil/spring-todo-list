//package com.OpenSource.demo.User;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtUtil jwtUtil;
//    private final UserDetailsService userDetailsService;
//
//    public JwtAuthenticationFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwt = null;
//
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwt = authorizationHeader.substring(7); // Extract the token without the "Bearer " prefix
//            username = jwtUtil.extractUsername(jwt);
//        }
//
//        // Check if username is not null and no authentication exists in the context
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//            // Validate the token
//            if (jwtUtil.validateToken(jwt, userDetails.getUsername())) {
//                PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//
//                // Set additional authentication details
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//
//                // Set the authentication in the SecurityContext
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        // Proceed with the next filter
//        filterChain.doFilter(request, response);
//    }
//}