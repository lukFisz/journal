package luk.fisz.journal.db.repos;

import luk.fisz.journal.db.models.Journal;
import luk.fisz.journal.db.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JournalRepo extends JpaRepository<Journal, Long> {
    List<Journal> findAllByUser(User user);
    Optional<Journal> findByIdAndUser(long id, User user);
    boolean existsByUser(User user);
}
