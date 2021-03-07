package luk.fisz.journal.services.user;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFetcherImpl implements UserFetcher {

    private final UserRepo userRepo;

    public UserFetcherImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> user = userRepo.findByUsername(username);
        return user.orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
    }

}
