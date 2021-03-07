package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.repos.EntryRepo;
import luk.fisz.journal.exception.NoSuchEntryException;
import luk.fisz.journal.service.journal.JournalFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class EntryFetcherImpl implements EntryFetcher {

    private final EntryRepo entryRepo;
    private final JournalFetcher journalFetcher;
    private final EntryOwnerChecker entryOwnerChecker;

    public EntryFetcherImpl(EntryRepo entryRepo, JournalFetcher journalFetcher, EntryOwnerChecker entryOwnerChecker) {
        this.entryRepo = entryRepo;
        this.journalFetcher = journalFetcher;
        this.entryOwnerChecker = entryOwnerChecker;
    }

    @Override
    public Entry get(long id) {
        return entryRepo.findById(id).orElseThrow(() -> new NoSuchEntryException(id));
    }

    @Override
    public Entry getByIdAndUsername(long entryID, String username) throws NoSuchEntryException {
        Entry entry = get(entryID);
        return entryOwnerChecker.checkAndReturn(entry, username);
    }

    @Override
    public Collection<Entry> getAllByJournalAndUsername(long journalID, String username) {
        Journal journal = journalFetcher.getByIdAndUsername(journalID, username);
        return entryRepo.findAllByJournal(journal);
    }

}
