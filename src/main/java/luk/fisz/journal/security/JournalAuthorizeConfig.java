package luk.fisz.journal.security;

import luk.fisz.journal.common.definition.route.UserRoute;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class JournalAuthorizeConfig {

    private final UserRoute userRoute;

    public JournalAuthorizeConfig(UserRoute userRoute) {
        this.userRoute = userRoute;
    }

    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(userRoute.REGISTER).anonymous()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

}
