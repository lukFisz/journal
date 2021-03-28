package luk.fisz.journal.service.mail.body;

public interface NewUserMailBodyFactory {
    String create(String username,
                  String email,
                  String firstname,
                  String lastname);
}
