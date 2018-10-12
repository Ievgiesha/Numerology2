package numerology.repository;

import numerology.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
