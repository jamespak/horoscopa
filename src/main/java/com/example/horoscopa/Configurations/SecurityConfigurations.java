package com.example.horoscopa.Configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username(GetUserProperties().getProperty("user.name"))
                .password(encoder.encode(GetUserProperties().getProperty("user.password")))
                .roles(GetUserProperties().getProperty("user.role"))
                .build();

            return new InMemoryUserDetailsManager(userDetails);

        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(auth);
        http.authorizeRequests()
                .mvcMatchers(("/horoscope/**")).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    private Properties GetUserProperties() {

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("user.name"));
            System.out.println(prop.getProperty("user.password"));
            System.out.println(prop.getProperty("user.role"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }



}
