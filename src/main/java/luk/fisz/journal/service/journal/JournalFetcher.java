package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;

import java.util.Collection;

public interface JournalFetcher {
    Collection<Journal> getAllByUser(String username);
}
