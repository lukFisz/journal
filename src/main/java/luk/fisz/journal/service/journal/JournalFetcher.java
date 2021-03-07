package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;

import java.util.Collection;

public interface JournalFetcher {
    Journal getById(long id);

    Collection<Journal> getAllByUsername(String username);

    Journal getByIdAndUsername(long id, String username);
}
