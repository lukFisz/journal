package luk.fisz.journal.service.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

import static luk.fisz.journal.common.MailSenderProperties.*;

@Service
public class MailSenderFactory {

    @Bean
    public JavaMailSender getMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(HOST);
        mailSender.setPort(PORT);

        mailSender.setUsername(USERNAME);
        mailSender.setPassword(PASSWORD);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", TRANSPORT_PROTOCOL);
        props.put("mail.smtp.starttls.enable", TLS);
        props.put("mail.smtp.auth", "true");

//        set to true for debug mode
        props.put("mail.debug", "false");

        return mailSender;
    }

}
