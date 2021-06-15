package luk.fisz.journal.service.mail.newuser;

import org.springframework.stereotype.Service;

@Service
public class NewUserMailBodyFactoryImpl implements NewUserMailBodyFactory {

    public String create(String username,
                         String email,
                         String firstname,
                         String lastname) {
        return "User '"+username+"' has been created.";
    }

}
