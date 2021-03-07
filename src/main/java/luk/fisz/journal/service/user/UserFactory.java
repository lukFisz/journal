package luk.fisz.journal.service.user;

import luk.fisz.journal.db.models.User;

public interface UserFactory {
    User create(String username,
                String password,
                String email,
                String firstname,
                String lastname);
}
