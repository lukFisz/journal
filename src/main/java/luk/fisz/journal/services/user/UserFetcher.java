package luk.fisz.journal.services.user;

import luk.fisz.journal.db.models.User;

public interface UserFetcher {
    User getByUsername(String username);
}
