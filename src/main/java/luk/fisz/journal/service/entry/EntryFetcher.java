package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.exception.NoSuchEntryException;

import java.util.Collection;

public interface EntryFetcher {

    Entry get(long id);

    Entry getByIdAndUsername(long entryID, String username) throws NoSuchEntryException;

    Collection<Entry> getAllByJournalAndUsername(long journalID, String username);
}
