package life.qbic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            List<String> isbn10List = Files.readAllLines(Path.of("isbn10.txt"));
            int failedCounter = 0;
            int succeededCounter = 0;
            for (String isbn10 : isbn10List) {
                try {
                    Isbn10.parse(isbn10);
                    succeededCounter++;
                } catch (IllegalArgumentException e) {
                    failedCounter++;
                    System.out.println("failed parsing " + isbn10);
                }
            }
            System.out.println("succeededCounter = " + succeededCounter);
            System.out.println("failedCounter = " + failedCounter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
