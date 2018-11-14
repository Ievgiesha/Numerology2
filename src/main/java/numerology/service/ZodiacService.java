package numerology.service;
import numerology.ChineseZodiak;
import numerology.ZodiacEnum;
import numerology.entities.Person;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ZodiacService {
    private PersonService personService;
    private ZodiacDefinition zodiacDefinition;
    private ZodiacEnum zodiacEnum;
    DescriptionReaderService descriptionReaderService;


    public String chineseSignForPersonId(Long id) {
        Person p = personService.getById(id);
        LocalDate birthday = p.getBirthday();
        ZodiacEnum zodiacSign = zodiacDefinition.findZodiacSign(birthday);
        return descriptionReaderService.readZodiacSignFromFile(zodiacSign);
    }


}
