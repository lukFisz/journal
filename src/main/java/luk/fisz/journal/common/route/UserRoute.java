package luk.fisz.journal.common.route;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:route.properties")
@ConfigurationProperties(prefix = "route-user")
@ConstructorBinding
@AllArgsConstructor
public class UserRoute {
    public final String REGISTER;
}
