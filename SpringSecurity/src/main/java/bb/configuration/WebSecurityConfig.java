package bb.configuration;

/**
 * Created by bartosz on 14.07.16.
 */

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests()
//                .antMatchers("/hello", "/", "/register", "/home", "/getAllPerson").permitAll()
//                .antMatchers("/abcde").access("hasRole('USER')").and()
//                .formLogin().loginProcessingUrl("/j_spring_security_check").loginPage("/login")
//                .usernameParameter("login").passwordParameter("password").defaultSuccessUrl("/index")
//                .failureUrl("/login?error=true").permitAll().and().sessionManagement().invalidSessionUrl("/index")
//                .sessionFixation().none().and().logout().invalidateHttpSession(false).logoutSuccessUrl("/login?logout")
//                .deleteCookies("JSESSIONID").permitAll();
//
//    }
}
