package luk.fisz.journal.config;

import luk.fisz.journal.common.mail.MailProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaMailSenderConfig {

    public final MailProperties mailProperties;

    public JavaMailSenderConfig(MailProperties mailProperties) {
        this.mailProperties = mailProperties;
    }

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailProperties.HOST);
        mailSender.setPort(mailProperties.PORT);

        mailSender.setUsername(mailProperties.USERNAME);
        mailSender.setPassword(mailProperties.PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailProperties.TRANSPORT_PROTOCOL);
        props.put("mail.smtp.starttls.enable", mailProperties.TLS);
        props.put("mail.smtp.auth", "true");

//        set to true for debug mode
        props.put("mail.debug", "false");

        return mailSender;
    }

}
