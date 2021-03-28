package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.exception.type.UserNotEntryOwnerException;
import org.springframework.stereotype.Service;

@Service
public class EntryOwnerCheckerImpl implements EntryOwnerChecker {

    @Override
    public Entry checkAndReturn(Entry entry, String claimant) throws UserNotEntryOwnerException {
        String username = entry.getJournal().getUser().getUsername();
        if (!username.equals(claimant)) {
            throw new UserNotEntryOwnerException(claimant, entry.getId());
        }
        return entry;
    }

}
