package luk.fisz.journal.service.user;

import luk.fisz.journal.db.models.User;

public interface UserFetcher {
    User getByUsername(String username);
}
