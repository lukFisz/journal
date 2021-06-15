package luk.fisz.journal.service.mail;

import luk.fisz.journal.common.util.mail.Mail;
import luk.fisz.journal.common.util.mail.MailSender;
import luk.fisz.journal.db.dto.UserDTO;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.service.mail.newuser.NewUserMailFactory;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static luk.fisz.journal.common.definition.AppBean.APP_ASYNC_EXEC;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    private final MailSender mailSender;
    private final ModelMapper modelMapper;
    private final NewUserMailFactory newUserMailFactory;

    public MailServiceImpl(MailSender mailSender, ModelMapper modelMapper, NewUserMailFactory newUserMailFactory) {
        this.mailSender = mailSender;
        this.modelMapper = modelMapper;
        this.newUserMailFactory = newUserMailFactory;
    }

    @Async(APP_ASYNC_EXEC)
    @Override
    public void sendNewUserMail(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        Mail mail = newUserMailFactory.create(userDTO);
        mailSender.send(mail);
    }

}
