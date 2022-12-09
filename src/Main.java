import classes.Car;
import classes.Person;
import enums.Colour;
import enums.Country;
import enums.Gender;
import service.impl.CarServiceImpl;
import service.impl.PersonServiceImpl;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "x5", new BigDecimal(500000), Year.of(2023), Colour.BLACK, Country.GERMANY);
        Car car1 = new Car("Camry", "75", new BigDecimal(450000), Year.of(2022), Colour.WHITE, Country.JAPON);
        Car car2 = new Car("Golf", "passat", new BigDecimal(25000), Year.of(2020), Colour.RED, Country.FRANCE);
        Car car3 = new Car("Tulpar", "Number1", new BigDecimal(55000), Year.of(2019), Colour.YELLOW, Country.KYRGYZSTAN);
        Car car4 = new Car("Mersedes", "220", new BigDecimal(23000), Year.of(1990), Colour.BLUE, Country.USA);
        Car car5 = new Car("Mazda", "24", new BigDecimal(33000), Year.of(2021), Colour.GREEN, Country.FRANCE);
        List<Car> cars = new ArrayList<>(List.of(car1, car2, car3, car4, car5));

        Person person = new Person("Nursutan", LocalDate.of(2004, 8, 9), Gender.MALE, new BigDecimal(1000000000), "+996700086780", null);
        Person person1 = new Person("Nurbek", LocalDate.of(2004, 1, 2), Gender.MALE, new BigDecimal(2000000000), "+996123123123", null);
        Person person2 = new Person("Nurgul", LocalDate.of(2005, 4, 5), Gender.FEMALE, new BigDecimal(10000000), "+996123456456", null);
        Person person3 = new Person("Meerim", LocalDate.of(2005, 8, 1), Gender.FEMALE, new BigDecimal(10000000), "+996123456789", null);
        Person person4 = new Person("Jazgul", LocalDate.of(2000, 8, 1), Gender.FEMALE, new BigDecimal(10000000), "+996123456789", null);
        List<Person> people = new ArrayList<>(List.of(person, person1, person2, person3,person4));

        PersonServiceImpl personService = new PersonServiceImpl();
        CarServiceImpl carService = new CarServiceImpl();
        while (true) {
            System.out.println("""
                 * ========================== *  
                ||    1. Create People!       ||
                ||    2. Get All People!      ||
                ||    3. Remove person!       ||
                ||    4. Find by name!        ||
                ||    5. Find by car name!    ||
                ||    6. Pay Car!             ||
                ||    7. Sort By DateOfBirth! ||
                ||    8. Sort by name!        ||
                ||    9. Sort by Gender!      ||
                ||    10. Show person age!    ||
                ||    11. Create car!         ||
                ||    12. Remove car!         ||
                ||    13. Get All Car!        ||
                ||    14. Get by country!     ||
                 * ========================== *                     
                    """);

            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1 -> personService.createPerson(people);
                case 2 -> {
                    for (Person p: personService.getAll()) {
                        System.out.println("Everyone's list is out");
                        System.out.println(p);
                    }
                }
                case 3 ->{
            Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Write person name to remove it.");
                    String name = scanner1.nextLine();
                    personService.removePerson(name, people);
                }
                case 4 -> {
                    Scanner scanner1 = new Scanner(System.in);

                    System.out.println("Write the name to find that person.");
                    String name = scanner1.nextLine();
                    personService.findByName(name, people);
                }
                case 5 -> {
                    Scanner scanner1 = new Scanner(System.in);

                    System.out.println("Write the name to find that car.");
                    String name = scanner1.nextLine();
                    personService.findByCarName(name, cars);
                }
                case 6 -> {
                    Scanner scanner1 = new Scanner(System.in);
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.println("Write the name to find that person.");
                    String name = scanner1.nextLine();
                    System.out.println("Write the name to find that car");
                    String carName = scanner2.nextLine();
                    System.out.println(personService.payCars(name, people, carName, cars));
                }
                case 7 -> {
                    personService.sortPersonDateOfBirth(people);
                    personService.getAll().forEach(System.out::println);
                }
                case 8 -> {
                    personService.sortPersonName(people);
                    personService.getAll().forEach(System.out::println);
                }
                case 9 -> {
                    personService.sortGender(people);
                    personService.getAll().forEach(System.out::println);
                }
                case 10 -> {
                    System.out.println("Jazgul's age: "+personService.getAge(person4));
                }
                case 11 -> {
                    System.out.println(carService.createCar(cars));
                }
                case 12 -> {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Write car name to remove it.");
                    String name = scanner1.nextLine();
                    System.out.println(carService.removeCar(name, cars));
                }
                case 13 -> {
                    carService.getAll().forEach(System.out::println);
                }
                case 14 -> {
                    Scanner scanner1 = new Scanner(System.in);

                    System.out.println("Write the name to find that Country");
                    String name = scanner1.nextLine();
                    carService.findByCountry(name, cars).forEach(System.out::println);
                }
            }

        }
    }
}

