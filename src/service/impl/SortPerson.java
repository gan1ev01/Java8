package service.impl;

import classes.Person;

import java.util.Comparator;

public class SortPerson implements Comparator <Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }


}
