package it.giachin.theaters.firenze.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.context.annotation.Configuration
public class Configuration {
     @Bean
    public ModelMapper modelMapper(){
         return new ModelMapper();
     }

     @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
         return new BCryptPasswordEncoder();
     }
}
