package com.example.realproperty;

import com.example.realproperty.service.impl.EmployeeServiceImpl;
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
    EmployeeServiceImpl employeeService;

    public static void main(String[] args) {
        SpringApplication.run(RealpropertyApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/admin/list-employee").failureUrl("/login?e=error").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/login?e=deny");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/client/css/**", "/client/js/**", "/client/font/**", "/client/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeService);
    }
}
