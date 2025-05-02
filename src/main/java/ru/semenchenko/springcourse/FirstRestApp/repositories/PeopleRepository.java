package ru.semenchenko.springcourse.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.semenchenko.springcourse.FirstRestApp.models.Person;

/**
 * @author Artyom Semenchenko
 */

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
