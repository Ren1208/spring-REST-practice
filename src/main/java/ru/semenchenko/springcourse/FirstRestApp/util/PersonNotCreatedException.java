package ru.semenchenko.springcourse.FirstRestApp.util;

/**
 * @author Artyom Semenchenko
 */
public class PersonNotCreatedException extends RuntimeException {
    public PersonNotCreatedException(String msg) {
        super(msg);
    }
}
