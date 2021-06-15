package luk.fisz.journal.service.mail.newuser;

public interface NewUserMailBodyFactory {
    String create(String username,
                  String email,
                  String firstname,
                  String lastname);
}
