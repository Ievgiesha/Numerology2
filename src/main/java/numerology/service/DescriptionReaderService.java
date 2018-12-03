package numerology.service;

import numerology.ZodiacEnum;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class DescriptionReaderService {
    String readDestinyDescriptionFromFile(int destinyNumber) {
        StringBuilder builder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/DiscriptionDestinyNumber"), StandardCharsets.UTF_8);
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
            lines = Files.readAllLines(Paths.get("src/main/resources/Compatibility"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean toRead = false;
        for (String line : lines) {
            if (line.contains(destinyNumber + " Life Path number")) {
                toRead = true;
            }
            if (line.contains((destinyNumber + 1) + " Life Path number")) {
                toRead = false;
            }
            if (toRead) {
                builder.append(line);
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    String findLettersFromName(String name) {
        StringBuffer stringBuffer = new StringBuffer();
        DescriptionReaderService descriptionReaderService = new DescriptionReaderService();
        String firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
        String lastLetter = String.valueOf(name.charAt(name.length() - 1)).toUpperCase();
        String nextFirstLetter;
        String nextLastLetter;
        if (!(firstLetter.equals("Z"))) {
            nextFirstLetter = descriptionReaderService.findNextLetter(firstLetter);
        } else {
            nextFirstLetter = "";
        }
        if (!(lastLetter.equals("Z"))) {
            nextLastLetter = descriptionReaderService.findNextLetter(lastLetter);
        } else {
            nextLastLetter = "";
        }
        stringBuffer.append(descriptionReaderService.readNameLettersFromFile(firstLetter, nextFirstLetter));
        stringBuffer.append(descriptionReaderService.readNameLettersFromFile(lastLetter, nextLastLetter));
        return stringBuffer.toString();
    }

    String readNameLettersFromFile(String nameLetter, String nextLetter) {
        //System.out.println("You name is " + nameLetter);
        StringBuilder builder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/TextLetter"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean toRead = false;
        for (String line : lines) {
          /*  if (line.contains("The Meaning of \"" + nextLetter + "\" in Your Name")) {
                toRead = false;
            }*/
            if (line.contains("The Meaning of \"" + nameLetter + "\" in Your Name")) {
                toRead = true;
            }
            if (line.contains("The Meaning of \"" + nextLetter + "\" in Your Name")) {
                toRead = false;
            }


            if (toRead) {
                builder.append(line);
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }


     String findNextLetter(String letter) {
        String[] alfabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String nextLetter = null;
        for (int i = 0; i < alfabet.length - 1; i++) {
            if (alfabet[i].equals(letter)) {
                nextLetter = alfabet[i+1];
            }
        }
        return nextLetter;
    }

    String readZodiacSignFromFile(ZodiacEnum enumZodiac) {
        StringBuilder builder = new StringBuilder();
        String enumName = enumZodiac.name;

        try {
            builder.append(Files.readAllLines(Paths.get("src/main/resources/" + enumName),
                    StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder.toString());
        return builder.toString();
    }
}