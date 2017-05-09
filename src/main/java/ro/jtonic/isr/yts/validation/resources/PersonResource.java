package ro.jtonic.isr.yts.validation.resources;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.jtonic.isr.yts.validation.model.ErrorMessage;
import ro.jtonic.isr.yts.validation.model.PersonQuery;
import ro.jtonic.isr.yts.validation.model.dto.PersonDto;
import ro.jtonic.isr.yts.validation.services.PersonService;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@RestController
@RequestMapping("/persons")
public class PersonResource {

    private PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody PersonDto person) {
        personService.addPerson(person);
    }

    @GetMapping("/find")
    public PersonDto getPerson(@RequestParam("id") String id) {
        return personService.getPerson(id);
    }

    @PostMapping("/query")
    public ResponseEntity<?> findBy(@Validated @RequestBody PersonQuery query, Errors errors) {
        if (errors.hasErrors()) {
            final String msg = errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                                         .collect(Collectors.joining(","));
            final ErrorMessage errMsg = ErrorMessage.builder().message("Invalid message").description(msg).build();
            return ResponseEntity.badRequest().body(errMsg);
        }
        return ResponseEntity.ok(personService.getPersonByQuery(query));
    }

    @PostMapping("/query1")
    public ResponseEntity<?> findBy1(@RequestBody PersonQuery query) {
        return ResponseEntity.ok(personService.getPersonByQuery1(query));
    }

    @GetMapping
    public Collection<PersonDto> getPersons() {
        return personService.getPersons();
    }

}
