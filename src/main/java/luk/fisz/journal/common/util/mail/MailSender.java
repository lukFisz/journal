package luk.fisz.journal.common.util.mail;

import org.springframework.scheduling.annotation.Async;

import static luk.fisz.journal.common.definition.AppBean.APP_ASYNC_EXEC;

public interface MailSender {
    @Async(APP_ASYNC_EXEC)
    void send(Mail mail);
}
