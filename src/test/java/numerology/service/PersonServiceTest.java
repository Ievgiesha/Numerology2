package numerology.service;
import numerology.entities.Person;
import numerology.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.util.Optional;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;
    @Mock
    private DescriptionReaderService descriptionReaderService;
    @InjectMocks
    private PersonService personService;

    @Test
    public void whatDestinyNumberTest() {
        //given
        Person person = new Person();
        person.setBirthday(LocalDate.of(1993, 11, 4));
        when(personRepository.findById(11L)).thenReturn(Optional.of(person));
        //when
        personService.tellDestiny(11L);
        //then
        verify(descriptionReaderService).readDestinyDescriptionFromFile(1);
    }
    @Test
    public void describeNameLettersTest(){
        //given
        Person person = new Person();
        person.setName("Anna");
        person.setId(11L);
        when(personRepository.findById(11L)).thenReturn(Optional.of(person));
        String name = person.getName();
        when(descriptionReaderService.findLettersFromName(name)).thenReturn("Anna");
        //when
        personService.describeNameLetters(11L);
        //then
        verify(descriptionReaderService).findLettersFromName(name);
       // doReturn("Anna").when(personService.describeNameLetters(11L));
    }
    @Test
    public void getCompatibilityTest(){
        //given
        LocalDate localDateP1 = LocalDate.of(1999,3,22);
        LocalDate localDateP2 = LocalDate.of(1993,7,17);
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setId(12L); p1.setName("Anna");    p1.setBirthday(localDateP1);
        p2.setId(13L); p2.setName("Gabriel");  p2.setBirthday(localDateP2);

        when(personRepository.findById(12L)).thenReturn(Optional.of(p1));
        when(personRepository.findById(13L)).thenReturn(Optional.of(p2));
        //when
        personService.getCompatibility(12L, 13L);
        //then
        verify(descriptionReaderService).readCompatibilityFromFile(8);
    }
    @Test
    public void tellDestinyTest(){
        //given
        LocalDate localDateP = LocalDate.of(1993,7,17);
        Person p = new Person();
        p.setId(13L); p.setName("Gabriel");  p.setBirthday(localDateP);
        //when
        when(personRepository.findById(13L)).thenReturn(Optional.of(p));
        when(descriptionReaderService.readDestinyDescriptionFromFile(1)).thenReturn("Successful description");
        personService.tellDestiny(13L);
        //then
        verify(descriptionReaderService).readDestinyDescriptionFromFile(1);

    }
}


