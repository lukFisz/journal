package luk.fisz.journal.services.journal;

import luk.fisz.journal.db.models.Journal;

import java.util.Collection;

public interface JournalFetcher {
    Collection<Journal> getAllByUser(String username);
}
