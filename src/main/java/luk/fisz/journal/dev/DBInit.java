package luk.fisz.journal.dev;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInit {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    public DBInit(PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    @PostConstruct
    void dbInit() {
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setEmail("");
        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword(passwordEncoder.encode("user1"));
        user1.setEmail("");
        userRepo.save(user);
        userRepo.save(user1);
    }

}
