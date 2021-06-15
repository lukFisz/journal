package luk.fisz.journal.common.util.mail;

import luk.fisz.journal.common.definition.mail.MailProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderImpl implements MailSender {

    private final Logger logger = LoggerFactory.getLogger(MailSenderImpl.class);

    private final MailProperties mailProperties;
    private final JavaMailSender mailSender;

    public MailSenderImpl(MailProperties mailProperties, JavaMailSender mailSender) {
        this.mailProperties = mailProperties;
        this.mailSender = mailSender;
    }

    @Override
    public void send(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.SENDER);
        message.setTo(mail.getReceiver());
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());
        mailSender.send(message);

        logger.info(
                "Email was sent. Receiver: " + mail.getReceiver()
                        + " | Event type: " + mail.getEventType()
        );
    }

}
