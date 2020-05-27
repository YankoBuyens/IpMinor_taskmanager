package com.taskmanager.taskmanager;

import com.taskmanager.taskmanager.model.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/signup").permitAll()
                .mvcMatchers("/jdbc:h2:mem:taak").hasAuthority("ADMIN")
                .mvcMatchers("tasks/new").hasAuthority("ADMIN")
                .mvcMatchers("tasks/update/{id}").hasAuthority("ADMIN")
                .mvcMatchers("tasks/update").hasAuthority("ADMIN")
                .mvcMatchers("tasks/{id}/sub/create").hasAuthority("ADMIN")
                .mvcMatchers("tasks/subtaak").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}
