import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class InputReader {

    public Person readPersonInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter  name ");
        String name = scanner.nextLine();
        LocalDate birthday = readDateOfBirthday(scanner);
        return new Person(name, birthday);
    }

    private LocalDate readDateOfBirthday(Scanner scanner) {
        String dayInput;
        LocalDate birthday = null;
        boolean condition = true;
        do {
            System.out.println("Please enter date of  birthday in those format: year-month-day.  For example: 1999-12-17 ");
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

    public boolean wouldYouLikeToKnownCompatibility() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to know about compatibility with you partner? ");
        System.out.println("If you would like to continue, press 1, if you want start again, please press 0.  ");
        String answer = scanner.nextLine();
        if (answer.equals("1")) {
            return true;
        }
        return false;
    }

    public void readInformationAboutPartner() {
        System.out.println("Please, enter date of you partner ");
        Person partner = readPersonInformation();
        System.out.println("Destiny number you partner are: " + partner.getDestinyNumber() + " Now you can to know about future...");
    }

    public boolean doYouWantToKnowValueName() {
        System.out.println("When decoding your own name, it's important to realize that in Numerology, each letter in your name has a " +
                "corresponding number, and that the placement of each letter determines the kind of influence that letter (and its " +
                "numerological meaning) has on you. To simplify things, we will refer to letters and their numerological meaning rather " +
                "than discuss the precise numbers they translate into.");
        System.out.println(" ");
        System.out.println("Do you want to know more about LETTERS OF YOU NAME?    If you would like to continue, press 1, if you want " +
                "to start  again, press 0.  ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("1")) {
            return true;
        }
        return false;
    }

}




