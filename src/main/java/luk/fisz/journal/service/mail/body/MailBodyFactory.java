package luk.fisz.journal.service.mail.body;

import java.io.IOException;
import java.util.Map;

public abstract class MailBodyFactory {
    protected final MailTemplateFetcher templateFetcher;
    public MailBodyFactory(MailTemplateFetcher templateFetcher) {
        this.templateFetcher = templateFetcher;
    }
    public abstract String create(String templateName, Map<String, Object> params) throws IOException;
}
