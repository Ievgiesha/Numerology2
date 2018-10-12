package numerology.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
@Setter
@Getter
@AllArgsConstructor
@Service
public class HoroscopeService {

    public String destinyNumberForBirthday(LocalDate localDate) {
        int destinyNumber = whatDestinyNumber(localDate);
        return readDestinyDescriptionFromFile(destinyNumber);
    }

    public String chineseZodiacForBirthday(LocalDate localDate) {

        return "";
    }

    public static void main(String[] args) {
        HoroscopeService horoscopeService =new HoroscopeService();
        System.out.println(horoscopeService.destinyNumberForBirthday(LocalDate.parse("1997-02-02")));
       /* PersonService personService = new PersonService();
        InputReaderService inputReaderService = new InputReaderService();
        Person p = inputReaderService.readPersonInformation();
        DescriptionReader descriptionReader = new DescriptionReader();*/
        //descriptionReader.readDestinyDescriptionFromFile(p.getDestinyNumber());
    }
    String readDestinyDescriptionFromFile(int destinyNumber) {
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

    private int whatDestinyNumber(LocalDate birthday) {
        int temp = Stream.of(birthday.toString().replaceAll("-", "0"))
                .flatMap(str -> Arrays.stream(str.split("")))
                .mapToInt(str -> Integer.parseInt(str)).
                        sum();
        int sum = temp % 10 + temp / 10;
        if (sum > 9) {
            sum = sum % 10 + sum / 10;
        }
        System.out.println("Number of destiny is: " + sum);
        return sum;
    }

    public  String readCompatibilityFromFile(int destinyNumber) {
        StringBuilder builder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/Text2"), StandardCharsets.UTF_8);
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

   public String findLettersFromName(String name) {
        StringBuffer stringBuffer = new StringBuffer();
        String firstLetter = String.valueOf(name.charAt(0)).toUpperCase();
        String lastLetter = String.valueOf(name.charAt(name.length() - 1)).toUpperCase();
        String nextFirstLetter;
        String nextLastLetter;
        if (!(firstLetter.equals("Z"))) {
            nextFirstLetter = findNextLetter(firstLetter);
        } else {
            nextFirstLetter = "Z";
        }
        if (!(lastLetter.equals("Z"))) {
            nextLastLetter = findNextLetter(lastLetter);
        } else {
            nextLastLetter = "Z";
        }
        stringBuffer.append(readNameLettersFromFile(firstLetter, nextFirstLetter));
        stringBuffer.append(readNameLettersFromFile(lastLetter, nextLastLetter));
        return stringBuffer.toString();
    }

    String readNameLettersFromFile(String nameLetter, String nextLetter) {
        System.out.println("You name is " + nameLetter);
        StringBuilder builder = new StringBuilder();
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/TextLetter"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean toRead = false;
        for (String line : lines) {
            if (line.contains("The Meaning of \"" + nextLetter + "\" in Your Name")) {
                toRead = false;
            }
            if (line.contains("The Meaning of \"" + nameLetter + "\" in Your Name")) {
                toRead = true;
            }

            if (toRead) {
                builder.append(line);
            }
        }
        System.out.println(builder.toString());
        return builder.toString();
    }


    public String findNextLetter(String letter) {
        String[] alfabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J`", "K", "L", "M", "N", "O", "P", "Q", "R",
                "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String nextLetter = "";
        for (int i = 0; i < alfabet.length - 1; i++) {
            if (alfabet[i].equals(letter)) {
                nextLetter = alfabet[i + 1];
            }
        }
        //return "" + (char) (Character.getNumericValue(letter.charAt(0)) + 1);
        return nextLetter;
    }

}
