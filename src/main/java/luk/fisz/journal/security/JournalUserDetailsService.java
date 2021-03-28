package luk.fisz.journal.security;

import lombok.AllArgsConstructor;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.service.user.UserFetcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JournalUserDetailsService implements UserDetailsService {

    private final UserFetcher userFetcher;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User _user = userFetcher.getByUsername(username);
        return new JournalUserPrincipal(_user);
    }

}
