package luk.fisz.journal.service.mail;

import luk.fisz.journal.db.models.User;

public interface MailService {
    void sendNewUserMail(User user);
}
