package ru.semenchenko.springcourse.FirstRestApp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.semenchenko.springcourse.FirstRestApp.models.Person;
import ru.semenchenko.springcourse.FirstRestApp.services.PeopleService;
import ru.semenchenko.springcourse.FirstRestApp.util.PersonErrorResponse;
import ru.semenchenko.springcourse.FirstRestApp.util.PersonNotFoundException;

import java.util.List;

/**
 * @author Artyom Semenchenko
 */

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертирует в JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id); // Jackson конвертирует в JSON
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found!",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // NOT_FOUND - 404 status
    }
}
