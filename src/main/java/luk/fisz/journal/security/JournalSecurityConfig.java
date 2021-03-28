package luk.fisz.journal.security;

import lombok.AllArgsConstructor;
import luk.fisz.journal.exception.handler.UnauthorizedExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class JournalSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JournalUserDetailsService journalUserDetailsService;
    private final UnauthorizedExceptionHandler unauthorizedExceptionHandler;
    private final SecurityPasswordEncoder securityPasswordEncoder;
    private final JournalAuthorizeConfig authorizeConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .authenticationEntryPoint(this.unauthorizedExceptionHandler);

        authorizeConfig.configure(http);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(journalUserDetailsService)
                .passwordEncoder(securityPasswordEncoder.getPasswordEncoder());
    }

}
