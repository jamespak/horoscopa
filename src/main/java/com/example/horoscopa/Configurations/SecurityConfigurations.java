package com.example.horoscopa.Configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class SecurityConfigurations {

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username(GetUserProperties().getProperty("user.name"))
                .password(GetUserProperties().getProperty("user.password"))
                .roles(GetUserProperties().getProperty("user.role"))
                .build();

            return new InMemoryUserDetailsManager(userDetails);

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
