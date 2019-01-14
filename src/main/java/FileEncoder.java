import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

class FileEncoder {
    String encodedString = "";
    public boolean fileToBase64StringConversion(String inputFilePath) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File inputFile = new File(classLoader
                    .getResource(inputFilePath)
                    .getFile());

            byte[] fileContent = FileUtils.readFileToByteArray(inputFile);

            encodedString = Base64
                    .getMimeEncoder()
                    .encodeToString(fileContent);

            PrintWriter out = new PrintWriter(new File(FileResourcePath.getResourcePath() + "/EncodedFile.txt"));
            out.write(encodedString);
            out.close();
            return true;

        } catch (IOException e) {
        }

        return false;
    }
}
