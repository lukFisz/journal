package luk.fisz.journal.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class JournalSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JournalUserDetailsService journalUserDetailsService;
    private final JournalBasicAuthEntryPoint journalBasicAuthEntryPoint;
    private final SecurityPasswordEncoder securityPasswordEncoder;

    public JournalSecurityConfig(JournalUserDetailsService journalUserDetailsService, JournalBasicAuthEntryPoint journalBasicAuthEntryPoint, SecurityPasswordEncoder securityPasswordEncoder) {
        this.journalUserDetailsService = journalUserDetailsService;
        this.journalBasicAuthEntryPoint = journalBasicAuthEntryPoint;
        this.securityPasswordEncoder = securityPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .authenticationEntryPoint(this.journalBasicAuthEntryPoint)
                .and()
                .authorizeRequests().antMatchers("/register").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(journalUserDetailsService)
                .passwordEncoder(securityPasswordEncoder.getPasswordEncoder());
    }

}
