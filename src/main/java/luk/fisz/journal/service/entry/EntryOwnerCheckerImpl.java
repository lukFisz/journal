package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.exception.UserNotEntryOwnerException;
import org.springframework.stereotype.Service;

@Service
public class EntryOwnerCheckerImpl implements EntryOwnerChecker {

    private final EntryFetcher entryFetcher;

    public EntryOwnerCheckerImpl(EntryFetcher entryFetcher) {
        this.entryFetcher = entryFetcher;
    }

    @Override
    public Entry checkAndReturn(Entry entry, String claimant) throws UserNotEntryOwnerException {
        String username = entry.getJournal().getUser().getUsername();
        if (!username.equals(claimant)) {
            throw new UserNotEntryOwnerException(claimant, entry.getId());
        }
        return entry;
    }

}