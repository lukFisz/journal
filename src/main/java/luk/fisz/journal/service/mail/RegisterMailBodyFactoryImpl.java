package luk.fisz.journal.service.mail;

import org.springframework.stereotype.Service;

@Service
public class RegisterMailBodyFactoryImpl implements RegisterMailBodyFactory {

    public String prepareBody(String username,
                               String email,
                               String firstname,
                               String lastname) {
        return "User '"+username+"' has been created.";
    }

}
