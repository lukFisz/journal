package luk.fisz.journal.service.mail.newuser;

import luk.fisz.journal.common.definition.mail.MailEventType;
import luk.fisz.journal.common.util.mail.Mail;
import luk.fisz.journal.common.util.mail.MailFactory;
import luk.fisz.journal.db.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class NewUserMailFactory extends MailFactory<UserDTO> {

    private final NewUserMailBodyFactory newUserMailBodyFactory;

    public NewUserMailFactory(NewUserMailBodyFactory newUserMailBodyFactory) {
        this.newUserMailBodyFactory = newUserMailBodyFactory;
    }

    @Override
    public Mail create(UserDTO userDTO) {
        String username = userDTO.getUsername();
        String email = userDTO.getEmail();
        String firstname = userDTO.getFirstname();
        String lastname = userDTO.getLastname();
        String body = newUserMailBodyFactory.create(username, email, firstname, lastname);
        return new Mail()
                .setBody(body)
                .setReceiver(userDTO.getEmail())
                .setEventType(MailEventType.USER_CREATION)
                .setSubject("Your account has been created.");
    }

}

