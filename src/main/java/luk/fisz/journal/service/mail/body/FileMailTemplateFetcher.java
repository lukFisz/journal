package luk.fisz.journal.service.mail.body;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileMailTemplateFetcher implements MailTemplateFetcher {

    @Override
    public String fetch(String templateName) {
        File file = new File("/home/lukaszf/"+templateName);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                stringBuilder.append(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
