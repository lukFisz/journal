package luk.fisz.journal.exception.type;

public class NoSuchEntryException extends RuntimeException {

    public NoSuchEntryException(long id) {
        super("There is no entry with id: " + id);
    }

}
