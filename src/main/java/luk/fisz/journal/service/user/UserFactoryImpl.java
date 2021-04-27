package luk.fisz.journal.service.user;

import luk.fisz.journal.common.mail.MailEventType;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.dto.Mail;
import luk.fisz.journal.service.mail.MailService;
import luk.fisz.journal.service.mail.body.MailBodyFactory;
import luk.fisz.journal.service.mail.body.NewUserMailBodyFactory;
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
    private final NewUserMailBodyFactory newUserMailBodyFactory;
    private final MailBodyFactory mailBodyFactory;

    public UserFactoryImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, MailService mailSender, NewUserMailBodyFactory newUserMailBodyFactory, MailBodyFactory mailBodyFactory) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.newUserMailBodyFactory = newUserMailBodyFactory;
        this.mailBodyFactory = mailBodyFactory;
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
//        user = userRepo.saveAndFlush(user);

        logger.info("New user was created. Username: " + username);

//todo

//        String body = newUserMailBodyFactory.create(username, email, firstname, lastname);
        Map<String, Object> templateParams = new HashMap<>();
        templateParams.put("username", username);
        templateParams.put("email", email);
        try {
            String body = mailBodyFactory.create("temp.txt", templateParams);
            System.out.println(body);
            Mail mail = new Mail()
                    .setBody(body)
                    .setReceiver(user.getEmail())
                    .setEventType(MailEventType.USER_CREATION)
                    .setSubject("Your account has been created.");
//            mailSender.send(mail);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
