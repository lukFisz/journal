package luk.fisz.journal.common.definition.route;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:route.properties")
@ConfigurationProperties(prefix = "entry")
@ConstructorBinding
@AllArgsConstructor
public class Entry {
    public final String ALL;
    public final String BY_ID;
    public final String CREATE;
}
