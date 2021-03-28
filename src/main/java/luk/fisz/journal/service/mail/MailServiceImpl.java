package luk.fisz.journal.service.mail;

import luk.fisz.journal.common.MailProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender mailSender;
    private final MailProperties mailProperties;

    public MailServiceImpl(JavaMailSender mailSender,
                           MailProperties mailProperties) {
        this.mailSender = mailSender;
        this.mailProperties = mailProperties;
    }

    @Override
    public void sendMail(String receiver, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.SENDER);
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

        logger.info("The email was send. Receiver: " + receiver);
    }

}
