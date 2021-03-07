package luk.fisz.journal.service.entry;

import luk.fisz.journal.db.models.Entry;
import luk.fisz.journal.exception.UserNotEntryOwnerException;

public interface EntryOwnerChecker {
    Entry checkAndReturn(Entry entry, String claimant) throws UserNotEntryOwnerException;
}
