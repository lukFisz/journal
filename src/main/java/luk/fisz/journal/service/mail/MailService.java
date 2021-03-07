package luk.fisz.journal.service.mail;

public interface MailService {
    void sendMail(String to, String subject, String body);
}
