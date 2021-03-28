package luk.fisz.journal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import luk.fisz.journal.common.mail.MailEventType;

@Setter @Getter @Accessors(chain = true)
@AllArgsConstructor @NoArgsConstructor
public class Mail {
    private String receiver;
    private String subject;
    private String body;
    private MailEventType eventType;
}
