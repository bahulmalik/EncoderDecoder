import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface FileResourcePath {
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
}
