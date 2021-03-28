package luk.fisz.journal.service.mail;

import luk.fisz.journal.common.mail.MailProperties;
import luk.fisz.journal.dto.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static luk.fisz.journal.common.AppBean.APP_ASYNC_EXEC;

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

    @Async(APP_ASYNC_EXEC)
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
