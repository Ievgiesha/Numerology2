import lombok.Data;

import java.time.LocalDate;
import java.util.*;

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


    //System.out.println(person2.getName()+" "+person2.destinyNumber);*/


    Calendar calendar = Calendar.getInstance();

    private int whatDestinyNumber(LocalDate birthday) {
        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();
        int year = birthday.getYear();
        int temp = year;
        int sum;
        if (day >= 10) {
            sum = (day - (day % 10)) / 10 + (day % 10);
            if (sum >= 10) {
                sum = (sum - (sum % 10)) + (sum % 10);
            }
        } else sum = day;
        if (month >= 10) {
            sum += ((month - (month % 10)) / 10 + (month % 10));
        } else sum += month;
        for (int i = 0; i < 3; i++) {
            sum += temp % 10;
            temp = (temp - (temp % 10)) / 10;
        }
        sum += temp;
        if (sum >= 10) {
            sum = (sum - (sum % 10)) / 10 + sum % 10;
            if (sum >= 10) {
                sum = (sum - (sum % 10)) / 10 + sum % 10;
            }
        }
        System.out.println("You number of destiny: " + sum);
        return sum;
    }


    private int whatDestinyNumber2(Calendar birthday) {
        String dateOfBirthday = birthday.toString();
        String[] number = dateOfBirthday.split("-");
        int rez = 0;
        for (String s : number) {
            rez += Integer.parseInt(s);
        }
        return rez;
    }

    public String compatibleWith(Person anotherPerson) {
        //this.destinyNumber
        //anotherPerson.destinyNumber
        return "";
    }
}
