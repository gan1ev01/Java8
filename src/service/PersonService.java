package service;

import classes.Car;
import classes.Person;

import java.util.List;

public interface PersonService {
    String createPerson(List<Person> people);

    String removePerson(String name, List<Person> people);

    List<Person> getAll();

    List<Person> findByName(String name, List<Person> people);

    List<Car> findByCarName(String name, List<Car> people);

    String payCars(String name, List<Person> person, String carName, List<Car> cars);

    List<Person>sortPersonDateOfBirth(List<Person>persons);

    List<Person>sortPersonName(List<Person>persons);

    List<Person>sortGender(List<Person> person);

    int getAge(Person person);
}
