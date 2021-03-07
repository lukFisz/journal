package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.repos.EntryRepo;
import luk.fisz.journal.exception.NoSuchEntryException;
import luk.fisz.journal.exception.UserNotEntryOwnerException;
import luk.fisz.journal.service.journal.JournalFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class EntryFetcherImpl implements EntryFetcher {

    private final EntryRepo entryRepo;
    private final JournalFetcher journalFetcher;

    public EntryFetcherImpl(EntryRepo entryRepo, JournalFetcher journalFetcher) {
        this.entryRepo = entryRepo;
        this.journalFetcher = journalFetcher;
    }

    @Override
    public Entry get(long id) {
        return entryRepo.findById(id).orElseThrow(() -> new NoSuchEntryException(id));
    }

    @Override
    public Entry getByIdAndUsername(long entryID, String username) throws NoSuchEntryException {
        Entry entry = this.get(entryID);
        String owner = entry.getJournal().getUser().getUsername();
        if (!owner.equals(username)) {
            throw new UserNotEntryOwnerException(username, entryID);
        }
        return entry;
    }

    @Override
    public Collection<Entry> getAllByJournalAndUsername(long journalID, String username) {
        Journal journal = journalFetcher.getByIdAndUsername(journalID, username);
        return entryRepo.findAllByJournal(journal);
    }

}
