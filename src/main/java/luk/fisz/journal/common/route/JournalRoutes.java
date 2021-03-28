package luk.fisz.journal.common.route;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:route.properties")
@ConfigurationProperties(prefix = "journal")
@ConstructorBinding
@AllArgsConstructor
public class JournalRoutes {
    public final String ALL;
    public final String BY_ID;
    public final String CREATE;
}