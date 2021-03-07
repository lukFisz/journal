package luk.fisz.journal.service.mail;

public interface RegisterMailBodyFactory {
    String prepareBody(String username,
                       String email,
                       String firstname,
                       String lastname);
}
