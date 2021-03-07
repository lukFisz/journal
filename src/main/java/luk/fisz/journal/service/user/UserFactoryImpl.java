package luk.fisz.journal.service.user;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import luk.fisz.journal.service.mail.MailService;
import luk.fisz.journal.service.mail.RegisterMailBodyFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserFactoryImpl implements UserFactory {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailSender;
    private final RegisterMailBodyFactory registerMailBodyFactory;

    public UserFactoryImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, MailService mailSender, RegisterMailBodyFactory registerMailBodyFactory) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.mailSender = mailSender;
        this.registerMailBodyFactory = registerMailBodyFactory;
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

        String body = registerMailBodyFactory.prepareBody(username, email, firstname, lastname);
        mailSender.sendMail(email, "Your account has been created.", body);

        return userRepo.saveAndFlush(user);
    }
}
