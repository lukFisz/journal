package luk.fisz.journal.service.user;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserFactoryImpl implements UserFactory {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserFactoryImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
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
        return userRepo.saveAndFlush(user);
    }
}
