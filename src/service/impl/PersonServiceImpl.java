package service.impl;

import classes.Car;
import classes.Person;
import service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    List<Person> people = new LinkedList<>();

    @Override
    public String createPerson(List<Person> people) {
        this.people = people;
        System.out.println("Dear user created");
        return null;

    }

    @Override
    public String removePerson(String name, List<Person> people) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                people.remove(person);

            }
        }
        return "Person is successfuly removed!";
    }

    @Override
    public List<Person> getAll() {
        return people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        for (Person person : this.people) {
            if (person.getName().equals(name)) {
                System.out.println(person);
            }
        }
        return this.people;
    }

    @Override
    public List<Car> findByCarName(String name, List<Car> cars) {
        List<Car> carList = new ArrayList<>();
            for (Car car :cars) {
                if (car.getName().equals(name)) {
                    carList.add(car);
                    System.out.println(car);
                }
            }
        return carList;
    }

    @Override

    public String payCars(String name, List<Person> people, String carName, List<Car> cars) {
        for (Person person : people) {
            if(person.getName().contains(name)){
                for (Car car : cars) {
                    if (car.getName().contains(carName)){
                        int n = person.getMoney().subtract(car.getPrice()).intValue();
                        if (n >= 0){
                            if (person.getCars() == null){
                                person.setCars(List.of(car));
                                cars.removeAll(cars);
                                cars.add(car);
                                cars.remove(car);
                                person.setMoney(person.getMoney().add(car.getPrice()));
                            }else {
                                person.setCars(cars);
                                cars.add(car);
                                cars.remove(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }
                            return "Dear customer you have bought a car.";
                        }else{
                            return "Dear customer you don't have enough money.";
                        }
                    }
                }
            }
        }

        return "Dear customer congratulations on getting a car.";
    }

    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> persons) {
        SortPerson sortPerson = new SortPerson();
        persons.sort(sortPerson);
        return persons;
    }

    @Override
    public List<Person> sortPersonName(List<Person> persons) {
        SortPersonByName sortPersonByName = new SortPersonByName();
        persons.sort(sortPersonByName);
//        persons.sort(sortPersonName)
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
        return persons;
    }

    @Override
    public List<Person> sortGender(List<Person> person) {
        SortPersonByGender sortPersonByGender = new SortPersonByGender();
        person.sort(sortPersonByGender);
        return person;
    }

    @Override
    public int getAge(Person person) {
        int a = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
        return a;
    }
}
