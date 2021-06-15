package luk.fisz.journal.common.util.mail;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class FileMailTemplateFetcher implements MailTemplateFetcher {

    @Override
    public String fetch(String pathToTemplate) {
        File file = new File(pathToTemplate);
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
