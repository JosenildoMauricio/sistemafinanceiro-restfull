//package com.spring.security;
//
//import br.com.utilitarios.Aplicacao;
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class JWTLoginFilter {
////
////    @Autowired
////    Aplicacao aplicacao;
////    
////    
////    protected JWTLoginFilter(String url, AuthenticationManager authManager) {
////        super(new AntPathRequestMatcher(url));
////        setAuthenticationManager(authManager);
////    }
////
////    @Override
////    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
////            throws AuthenticationException, IOException, ServletException {
////    }
////
////    @Override
////    protected void successfulAuthentication(
////            HttpServletRequest request,
////            HttpServletResponse response,
////            FilterChain filterChain,
////            Authentication auth) throws IOException, ServletException {
////
////        TokenAuthenticationService.addAuthentication(response, auth.getName());
////    }
////
////    private String getIp(HttpServletRequest request) {
////        String ipAddress = request.getHeader("X-FORWARDED-FOR");
////        if (StringUtils.isBlank(ipAddress)) {
////            ipAddress = request.getRemoteAddr();
////        }
////        return ipAddress;
////    }
//}
