package luk.fisz.journal.services.journal;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import luk.fisz.journal.db.repos.JournalRepo;
import luk.fisz.journal.services.user.UserFetcher;
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

}
