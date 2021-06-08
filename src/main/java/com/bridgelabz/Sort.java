package com.bridgelabz;

import java.util.Collections;
import java.util.List;

public class Sort {

    public static void  sortByName(List<Person>person) {
        Collections.sort(person, Person.firstNameSorting);
        for(Person n: person)
        {
            System.out.println(n);
        }
    }

    public  static void sortByCity(List<Person>person) {
        Collections.sort(person, Person.citySorting);
        for(Person c : person)
        {
            System.out.println(c);
        }
    }
}
