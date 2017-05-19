package ro.jtonic.isr.yts.validation.services;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ro.jtonic.isr.yts.validation.model.PersonQuery;
import ro.jtonic.isr.yts.validation.model.dto.PersonDto;
import ro.jtonic.isr.yts.validation.repositories.PersonRepository;
import ro.jtonic.isr.yts.validation.validators.FastValidationGroup;
import ro.jtonic.isr.yts.validation.validators.ResourceConsumingGroup;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Component
@Validated
public class PersonService {

    private PersonRepository personRepository;

    private Validator validator;

    public PersonService(
            PersonRepository personRepository,
            Validator validator) {
        this.personRepository = personRepository;
        this.validator = validator;
    }

    public void addPerson(PersonDto person) {
        System.out.printf("The '%s' has been added\n", person);
        personRepository.savePerson(person);
    }

    public Collection<PersonDto> getPersons() {
        return this.personRepository.getPersons();
    }

    public PersonDto getPerson(@NotBlank String id) {
        return this.personRepository.getPerson(id);
    }

    public PersonDto getPersonByQuery(PersonQuery query) {
        return personRepository.getByName(query.getName());
    }

    public PersonDto getPersonByQuery1(@Valid PersonQuery query) {
        return null;
//        final Set<ConstraintViolation<PersonQuery>> constraints = validator.validate(query,
//                FastValidationGroup.class,
//                ResourceConsumingGroup.class);
//        if (constraints.isEmpty()) {
//            return personRepository.getByName(query.getName());
//        }
//        throw new ConstraintViolationException(constraints);
    }
}
