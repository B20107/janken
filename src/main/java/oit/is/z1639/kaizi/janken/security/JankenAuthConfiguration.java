package oit.is.z1639.kaizi.janken.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class JankenAuthConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService() {

    UserBuilder users = User.builder();

    UserDetails user1 = users
        .username("user1")
        .password("$2y$10$1/Lye5k7Y4K8BiVg/LyOEOPIUnmZi.kExtNmPqm1U6Tyr6cwKvpc.")
        .roles("USER")
        .build();
    UserDetails user2 = users
        .username("user2")
        .password("$2y$10$yzIC0y/oVkrVPUhp1RVZzeyn24KJumjy4PwgVKopkGDl9mCzUHfpi")
        .roles("USER")
        .build();
    UserDetails ほんだ = users
        .username("ほんだ")
        .password("$2y$10$I95/gkymE10UbgISebTHZeuaFKsZ5tUXi1zGlAWQdlgHmBBijvX96")
        .roles("USER")
        .build();
    UserDetails いがき = users
        .username("いがき")
        .password("$2y$10$S0CJPr79o4ZNPSd335Z4a.tvMwG89hCWz88qxoUE5G6Te4g8NukRK")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user1, user2, ほんだ, いがき);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.formLogin();

    http.authorizeHttpRequests()
        .mvcMatchers("/janken/**").authenticated();

    // http.authorizeHttpRequests()
    // .mvcMatchers("/sample3/**").permitAll();

    http.logout().logoutSuccessUrl("/");

    http.csrf().disable();
    http.headers().frameOptions().disable();
    return http.build();

  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
