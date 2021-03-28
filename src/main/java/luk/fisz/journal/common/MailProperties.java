package luk.fisz.journal.common;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "app.mail")
@ConstructorBinding
@AllArgsConstructor
public class MailProperties {

    public final String SENDER;
    public final String TRANSPORT_PROTOCOL;
    public final String HOST;
    public final int PORT;
    public final boolean SSL;
    public final boolean TLS;
    public final String USERNAME;
    public final String PASSWORD;

}
