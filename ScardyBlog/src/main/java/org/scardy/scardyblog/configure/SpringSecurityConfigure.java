package org.scardy.scardyblog.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigure  {
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();   // 비밀번호 암호화 객체
      return encoder;
   }

   @Bean
   SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http
       .authorizeHttpRequests(requests -> requests
               //.requestMatchers("/writeBlog").hasRole("ADMIN")
               .anyRequest().permitAll())
       .formLogin(login -> login
               .loginPage("/loginForm")
               .loginProcessingUrl("/login")
               .defaultSuccessUrl("/home"))
       .logout(logout -> logout
               .logoutUrl("/logout")
               .logoutSuccessUrl("/loginForm"));

       return http.build();
   }
   

}