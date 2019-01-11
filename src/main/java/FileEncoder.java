import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

class FileEncoder {
    String encodedString = "";

    static String getResourcePath() {
        try {

            URI resourcePathFile = System.class.getResource("/RESOURCE_PATH.properties").toURI();

            String resourcePath = Files.readAllLines(Paths.get(resourcePathFile)).get(0);

            URI rootURI = new File("").toURI();
            URI resourceURI = new File(resourcePath).toURI();
            URI relativeResourceURI = rootURI.relativize(resourceURI);

            return relativeResourceURI.getPath();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean fileToBase64StringConversion(String inputFilePath) {

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            File inputFile = new File(classLoader
                    .getResource(inputFilePath)
                    .getFile());

            byte[] fileContent = FileUtils.readFileToByteArray(inputFile);

            encodedString = Base64.getMimeEncoder().encodeToString(fileContent);

            PrintWriter out = new PrintWriter(new File(getResourcePath() + "/EncodedFile.txt"));
            out.write(encodedString);
            out.close();
            return true;

        } catch (IOException e) {
        }

        return false;
    }
}
