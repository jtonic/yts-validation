package ro.jtonic.isr.yts.validation.repositories;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import ro.jtonic.isr.yts.validation.model.dto.PersonDto;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Component
public class PersonRepository {

    private Map<String, PersonDto> persons = Maps.newHashMap();

    public void savePerson(PersonDto person) {
        persons.put(UUID.randomUUID().toString(), person);
    }

    public Collection<PersonDto> getPersons() {
        return persons.values();
    }

    public PersonDto getPerson(String id) {
        return persons.get(id);
    }

    public PersonDto getByName(String name) {
        for (PersonDto person : persons.values()) {
            if (name.equals(person.getName())) {
                return person;
            }
        }
        return null;
    }
}
