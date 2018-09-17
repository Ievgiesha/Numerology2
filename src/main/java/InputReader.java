import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class InputReader {

    public Person readPersonInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter you name ");
        String name = scanner.nextLine();
        LocalDate birthday = readDateOfBirthday(scanner);
        return new Person(name, birthday);
    }

    static StringBuilder readFromFile(StringBuilder builder, int destinyNumber) throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("src/main/resources/Text"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
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
        return builder;
    }


    private LocalDate readDateOfBirthday(Scanner scanner) {
        String dayInput;
        LocalDate birthday = null;
        boolean condition = true;
        do {
            System.out.println("Please enter date of you birthday in those format: year-month-day.  For example: 1999-12-17 ");
            if (scanner.hasNextLine()) {
                dayInput = scanner.nextLine();
            } else {
                System.out.println(" Please, enter correct date... ");
                continue;
            }
            try {
                birthday = LocalDate.parse(dayInput);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. ");
                continue;
            }
            condition = false;
        } while (condition);
        System.out.println(birthday);
        return birthday;
    }

    private boolean wouldYouLikeToKnownCompatibility() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to know about compatibility with you partner? ");
        System.out.println("If you would like to continue, press 1, if you want start again, please press 0.  ");
        String answer = scanner.nextLine();
        Person p1 = new InputReader().readPersonInformation();
        Person p2 = new InputReader().readPersonInformation();
        System.out.println(p1.compatibleWith(p2));
        if (answer.equals("1")) {
            return true;
        }
        return false;
    }



}