package numerology.controllers;

import numerology.entities.Person;
import numerology.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @GetMapping("/{id}/destiny-number")
    public String destinyNumberDescription(@PathVariable Long id) {
        return personService.tellDestiny(id);
    }

    @GetMapping("/{id1}/compatibility/{id2}")
    public String compatibilityDescription(@PathVariable Long id1, @PathVariable Long id2) {
        return personService.getCompatibility(id1, id2);
    }
     @GetMapping("/{id}/name-letter")
    public String descriptionForLetter(@PathVariable Long id){
        return personService.describeNameLetters(id);
     }
}
