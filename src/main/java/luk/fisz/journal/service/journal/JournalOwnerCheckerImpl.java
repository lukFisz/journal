package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.exception.type.UserNotJournalOwnerException;
import org.springframework.stereotype.Service;

@Service
public class JournalOwnerCheckerImpl implements JournalOwnerChecker {

    @Override
    public Journal checkAndReturn(Journal journal, String claimant) {
        String owner = journal.getUser().getUsername();
        if (!owner.equals(claimant)) {
            throw new UserNotJournalOwnerException(claimant, journal.getId());
        }
        return journal;
    }

}
