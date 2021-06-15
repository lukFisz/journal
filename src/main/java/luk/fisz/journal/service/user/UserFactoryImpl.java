package luk.fisz.journal.service.user;

import luk.fisz.journal.common.definition.mail.MailEventType;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.common.util.mail.Mail;
import luk.fisz.journal.service.mail.MailService;
import luk.fisz.journal.common.util.mail.MailTemplateEngine;
import luk.fisz.journal.service.mail.newuser.NewUserMailBodyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserFactoryImpl implements UserFactory {

    private final Logger logger = LoggerFactory.getLogger(UserFactory.class);

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailSender;

    public UserFactoryImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, MailService mailSender) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
    }

    @Override
    public User create(String username,
                       String password,
                       String email,
                       String firstname,
                       String lastname) {

        User user = new User()
                .setUsername(username)
                .setPassword(passwordEncoder.encode(password))
                .setActive(true)
                .setRole("USER")
                .setEmail(email)
                .setFirstname(firstname)
                .setLastname(lastname);
        user = userRepo.saveAndFlush(user);

        logger.info("New user was created. Username: " + username);

        mailSender.sendNewUserMail(user);

        return user;
    }
}
