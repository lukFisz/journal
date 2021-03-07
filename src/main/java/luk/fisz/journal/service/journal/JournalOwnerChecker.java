package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;

public interface JournalOwnerChecker {
    Journal checkAndReturn(Journal journal, String claimant);
}
