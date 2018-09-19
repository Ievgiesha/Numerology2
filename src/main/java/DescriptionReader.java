import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DescriptionReader {
    String readDestinyDescriptionFromFile(int destinyNumber)  {
        StringBuilder builder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/Text1"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean toRead = false;
        for (String line : lines) {
            if (line.contains("The number " + destinyNumber)) {
                toRead = true;
            }
            if (line.contains("The number " + (destinyNumber + 1))) {
                toRead = false;
            }
            if (toRead) {
                builder.append(line);
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }


    String readCompatibilityFromFile(int destinyNumber) {
        StringBuilder builder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/Text2"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean toRead = false;
        for (String line : lines) {
            if (line.contains(destinyNumber+" Life Path number")) {
                toRead = true;
            }
            if (line.contains((destinyNumber + 1)+" Life Path number")) {
                toRead = false;
            }
            if (toRead) {
                builder.append(line);
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

}
