package luk.fisz.journal.common.util.mail;

public abstract class MailFactory<T> {
    protected abstract Mail create(T t);
}
