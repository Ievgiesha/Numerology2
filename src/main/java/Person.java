import lombok.Data;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@Data
public class Person {
    private String name;
    private int destinyNumber;
    private LocalDate birthday;

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.destinyNumber = whatDestinyNumber(birthday);
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
        System.out.println("You number of destiny: " + sum);
        return sum;
    }

    public String compatibleWith(Person anotherPerson) {
        //this.destinyNumber
        //anotherPerson.destinyNumber
        return "";
    }
}
