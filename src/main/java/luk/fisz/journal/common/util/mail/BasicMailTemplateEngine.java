package luk.fisz.journal.common.util.mail;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BasicMailTemplateEngine extends MailTemplateEngine {

    public BasicMailTemplateEngine(MailTemplateFetcher mailTemplateFetcher) {
        super(mailTemplateFetcher);
    }

    @Override
    public String render(String templateName, Map<String, Object> params) {
        AtomicReference<String> template = new AtomicReference<>(this.templateFetcher.fetch(templateName));
        params.forEach((s, o) -> template.set(template.get().replace("${" + s + "}", o.toString())));
        return template.get();
    }

}
