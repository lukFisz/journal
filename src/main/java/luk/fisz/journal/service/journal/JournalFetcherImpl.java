package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.exception.type.NoSuchJournalException;
import luk.fisz.journal.service.user.UserFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class JournalFetcherImpl implements JournalFetcher {

    private final JournalRepo journalRepo;
    private final UserFetcher userFetcher;
    private final JournalOwnerChecker journalOwnerChecker;

    public JournalFetcherImpl(JournalRepo journalRepo, UserFetcher userFetcher, JournalOwnerChecker journalOwnerChecker) {
        this.journalRepo = journalRepo;
        this.userFetcher = userFetcher;
        this.journalOwnerChecker = journalOwnerChecker;
    }

    @Override
    public Journal get(long id) throws NoSuchJournalException {
        return journalRepo.findById(id).orElseThrow(() -> new NoSuchJournalException(id));
    }

    @Override
    public Collection<Journal> getAllByUsername(String username) {
        User user = userFetcher.getByUsername(username);
        return journalRepo.findAllByUser(user);
    }

    @Override
    public Journal getByIdAndUsername(long id, String username) throws NoSuchJournalException {
        Journal journal = this.get(id);
        return journalOwnerChecker.checkAndReturn(journal, username);
    }

}
