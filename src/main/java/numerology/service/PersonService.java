package numerology.service;
import numerology.entities.Person;
import numerology.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final DescriptionReaderService descriptionReaderService;

    public PersonService(PersonRepository personRepository, DescriptionReaderService descriptionReaderService) {
        this.personRepository = personRepository;
        this.descriptionReaderService = descriptionReaderService;
    }


    public Person save(Person person) {
        System.out.println(person);
        return personRepository.save(person);
    }

    public Person getById(Long id) {
        return personRepository.findById(id).get();
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

    public String tellDestiny(Long id) {
        Person p = getById(id);
        LocalDate persondate = p.getBirthday();
        int destinyNumber = whatDestinyNumber(persondate);
        return descriptionReaderService.readDestinyDescriptionFromFile(destinyNumber);
    }

    public String getCompatibility(Long id1, Long id2) {
        Person p1 = getById(id1);
        Person p2 = getById(id2);
        LocalDate persondate1 = p1.getBirthday();
        LocalDate persondate2 = p2.getBirthday();
        int destinyNumber1 = whatDestinyNumber(persondate1);
        int destinyNumber2 = whatDestinyNumber(persondate2);
        System.out.println("Compatibility description"+System.lineSeparator()+"for:  "+p1.getName()
        +"   you partner with destiny number:  "+destinyNumber2);
        System.out.println(" ");
        return descriptionReaderService.readCompatibilityFromFile(destinyNumber1);
    }

    public String describeNameLetters(Long id){
        Person p = getById(id);
        String name = p.getName();
        try {
            return descriptionReaderService.findLettersFromName(name);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "";
    }
}
