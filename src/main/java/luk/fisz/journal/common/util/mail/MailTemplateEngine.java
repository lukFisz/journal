package luk.fisz.journal.common.util.mail;

import java.io.IOException;
import java.util.Map;

public abstract class MailTemplateEngine {
    protected final MailTemplateFetcher templateFetcher;
    public MailTemplateEngine(MailTemplateFetcher templateFetcher) {
        this.templateFetcher = templateFetcher;
    }
    public abstract String render(String templateName, Map<String, Object> params) throws IOException;
}
