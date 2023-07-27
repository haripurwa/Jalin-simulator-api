package jpn.jalin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@Slf4j
public class ReadFileService {

    public String readData(String req) {
        String payload = null;
        try {
            String filePath = "src/main/resources/templates/req.txt";
            try {
                String data = readFile(filePath, StandardCharsets.UTF_8);
                String[] ary = data.split(",,");
                if (req.equals("payment")) {
                    payload = ary[0];
                } else if (req.equals("check")) {
                    payload = ary[1];
                } else {
                    payload = ary[2];
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("request payload : "+req);
            log.info("data from req.txt " +payload);
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }

        return payload;
    }

    private static String readFile(String path, Charset encoding) throws IOException {
        return Files.readString(Paths.get(path), encoding);
    }
}
