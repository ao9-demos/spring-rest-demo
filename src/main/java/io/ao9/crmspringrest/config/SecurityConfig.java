package io.ao9.crmspringrest.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // // Memory auth
        // UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        // auth.inMemoryAuthentication()
        // .withUser(userBuilder.username("user").password("user").roles("USER"))
        // .withUser(userBuilder.username("mng").password("mng").roles("USER", "MANAGER"))
        // .withUser(userBuilder.username("admin").password("admin").roles("USER", "ADMIN"));

        // Database auth
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()

                .antMatchers(HttpMethod.GET, "/api/customers/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/customers/**").hasAnyRole("MANAGER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("ADMIN")

                .antMatchers("/actuator/**").hasRole("ADMIN")
                .antMatchers("/customer/**").hasRole("USER")
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/system/**").hasRole("ADMIN")
            .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
            .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
            .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
            .and()
                .httpBasic()
            .and()
                .csrf().disable(); //for api POST
                // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // force auth for each api request

    }
}