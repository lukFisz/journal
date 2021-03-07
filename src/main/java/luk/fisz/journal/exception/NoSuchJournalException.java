package luk.fisz.journal.exception;

public class NoSuchJournalException extends RuntimeException {

    public NoSuchJournalException(long id) {
        super("There is no journal with id: "+id);
    }

}
