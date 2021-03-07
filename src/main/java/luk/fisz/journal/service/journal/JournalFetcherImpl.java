package luk.fisz.journal.service.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.exception.NoSuchJournalException;
import luk.fisz.journal.service.user.UserFetcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class JournalFetcherImpl implements JournalFetcher {

    private final JournalRepo journalRepo;
    private final UserFetcher userFetcher;

    public JournalFetcherImpl(JournalRepo journalRepo, UserFetcher userFetcher) {
        this.journalRepo = journalRepo;
        this.userFetcher = userFetcher;
    }

    @Override
    public Collection<Journal> getAllByUser(String username) {
        User user = userFetcher.getByUsername(username);
        return journalRepo.findAllByUser(user);
    }

    @Override
    public Journal getByIdAndUsername(long id, String username) {
        User user = userFetcher.getByUsername(username);
        return journalRepo.findByIdAndUser(id, user).orElseThrow(() -> new NoSuchJournalException(id));
    }

}
