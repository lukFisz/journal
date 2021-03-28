package luk.fisz.journal.service.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static luk.fisz.journal.common.MailSenderProperties.SENDER_ADDRESS;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender mailSender;

    public MailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMail(String receiver, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER_ADDRESS);
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);

        logger.info("The email was send. Receiver: " + receiver);
    }

}
