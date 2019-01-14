import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class FileDecoder {

    boolean fileToBase64Decoder(String fileToBeDecoded) {


        try {
            File decodedFile = new File(FileResourcePath.getResourcePath() + "/DecodedFile.jpg");
            final String content = new String(Files.readAllBytes(Paths.get(getClass().getResource(fileToBeDecoded).toURI())));

            byte[] decodedBytes = Base64
                    .getMimeDecoder()
                    .decode(content);

            FileUtils.writeByteArrayToFile(decodedFile, decodedBytes);
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return false;
    }
}
