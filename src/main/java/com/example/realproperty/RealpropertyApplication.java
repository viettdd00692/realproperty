package com.example.realproperty;

import com.example.realproperty.service.impl.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class RealpropertyApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    UserLoginService userLoginService;

    public static void main(String[] args) {
        SpringApplication.run(RealpropertyApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/admin/dashboard")
                .failureUrl("/login?error").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userLoginService);
    }

}