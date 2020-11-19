package luk.fisz.journal.security;

import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User _user = userRepo.findByUsername(s)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );
        return new CustomUserPrincipal(_user);
    }

}
