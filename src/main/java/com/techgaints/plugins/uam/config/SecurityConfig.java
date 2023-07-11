package com.techgaints.plugins.uam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity(debug = true)
//@EnableGlobalMethodSecurity() /* if we uncomment this, we get an error
// --Factory method 'methodSecurityMetadataSource' threw exception; nested exception is java.lang.IllegalStateException: In the composition of all global method configuration, no annotation support was actually activated
// To fix that error, either enable one of the metadata sources in the @EnableGlobalMethodSecurity
// EnableGlobalMethodSecurity, GlobalMethodSecurityConfiguration, customMethodSecurityMetadataSource*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.httpBasic().disable().csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().hasAuthority("/**");
        /*security.httpBasic().disable();
                .cors().and().csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().disable() // <-- this will disable the login route
                .addFilter(JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        */
                // security.httpBasic().disable(); // Did work only for GET
                // security.csrf().disable().authorizeRequests().anyRequest().permitAll(); // Works for GET, POST, PUT, DELETE    }

    }
    /*@Bean
    private void corsConfigurationSource(): CorsConfigurationSource {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration().applyPermitDefaultValues()
        config.addExposedHeader("Authorization")
        source.registerCorsConfiguration("/**", config)
        return source
    }*/
}
