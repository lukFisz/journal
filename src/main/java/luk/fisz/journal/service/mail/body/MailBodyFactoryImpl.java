package luk.fisz.journal.service.mail.body;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class MailBodyFactoryImpl extends MailBodyFactory {

    public MailBodyFactoryImpl(FileMailTemplateFetcher mailTemplateFetcher) {
        super(mailTemplateFetcher);
    }

    @Override
    public String create(String templateName, Map<String, Object> params) throws IOException {
        AtomicReference<String> template = new AtomicReference<>(this.templateFetcher.fetch(templateName));
        params.forEach((s, o) -> {
            template.set(template.get().replace("${" + s + "}", o.toString()));
        });
        return template.get();
    }
}
