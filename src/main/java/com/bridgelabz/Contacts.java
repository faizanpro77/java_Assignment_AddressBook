package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class Contacts {

    Scanner scanner = new Scanner(System.in);
    List<Person> personList = new ArrayList<Person>();

    public void addDetails() {
        String firstName = null, lastName, address, city, state, zip, phoneNum, email;
        int i = 0;
        while (i == 0) {
            System.out.println("Enter First Name : ");
            firstName = String.valueOf(scanner.next());
            if (checkExist(firstName)) {
                System.out.println("Person name is already exist");
                break;
            } else {
                i = 1;
            }
        }
        System.out.println("Enter first name");
        firstName = scanner.next();
        System.out.println("Enter last name");
        lastName = scanner.next();
        System.out.println("Enter address");
        address = scanner.next();
        System.out.println("Enter city");
        city = scanner.next();
        System.out.println("Enter state");
        state = scanner.next();
        System.out.println("Enter zip number");
        zip = scanner.next();
        System.out.println("Enter phone number");
        phoneNum = scanner.next();
        System.out.println("Enter email");
        email = scanner.next();
        personList.add(new Person(firstName, lastName, address, city, state, zip, phoneNum, email));
    }

    public void displayDetails() {
        if (personList.isEmpty()) {
            System.out.println("No records");
        } else {
            for (Person person : personList) {
                System.out.println(person);
            }
        }
    }

    public void editDetails() {
        int id, choice = 0, i = 0;
        String firstName, lastName, address, city, state, zip, phoneNum, email;
        for (Person person : personList) {
            System.out.println("ID:#" + personList.indexOf(person) + " : " + person);
        }
        System.out.println("Enter #ID to edit contact : ");
        id = Integer.valueOf(scanner.next());
        System.out.println(personList.get(id));
        while (i == 0) {
            System.out.println("Enter #ID to edit contact details:");
            System.out.println("1 for  first name:");
            System.out.println("2 for  last name:");
            System.out.println("3 for address:");
            System.out.println("4 for city:");
            System.out.println("5 for state:");
            System.out.println("6 for  zip number:");
            System.out.println("7 for phone number:");
            System.out.println("8 for email:");
            System.out.println("9 for save and exit:");

            choice = Integer.valueOf(scanner.next());
            System.out.println("your choice for edit details : " + choice);
            switch (choice) {
                case 1:
                    System.out.print("Enter new firstname : ");
                    firstName = String.valueOf(scanner.next());
                    personList.get(id).setFirstName(firstName);
                    break;
                case 2:
                    System.out.print("Enter new lastname : ");
                    lastName = String.valueOf(scanner.next());
                    personList.get(id).setLastName(lastName);
                    break;
                case 3:
                    System.out.print("Enter new address : ");
                    address = String.valueOf(scanner.next());
                    personList.get(id).setAddress(address);
                    break;
                case 4:
                    System.out.print("Enter new city : ");
                    city = String.valueOf(scanner.next());
                    personList.get(id).setCity(city);
                    break;
                case 5:
                    System.out.print("Enter new state : ");
                    state = String.valueOf(scanner.next());
                    personList.get(id).setState(state);
                    break;
                case 6:
                    System.out.print("Enter new zip : ");
                    zip = String.valueOf(scanner.next());
                    personList.get(id).setZip(zip);
                    break;
                case 7:
                    System.out.print("Enter new phoneNum : ");
                    phoneNum = String.valueOf(scanner.next());
                    personList.get(id).setPhoneNum(phoneNum);
                    break;
                case 8:
                    System.out.print("Enter new email : ");
                    email = String.valueOf(scanner.next());
                    personList.get(id).setEmail(email);
                    break;
                case 9:
                    i = 1;
                    break;
                default:
                    System.out.println("select valid option");
                    break;
            }
            System.out.println(personList.get(id));
        }
    }

    public void deleteDetails() {
        int id;
        for (Person p : personList) {
            System.out.println("ID: #" + personList.indexOf(p) + " : " + p);
            System.out.println("\nEnter #ID to delete contact : ");
            id = Integer.valueOf(scanner.next());
            personList.remove(id);
        }
    }

    public boolean checkExist(String firstName) {
        int flag = 0;
        for (Person p : personList) {
            if (p.getFirstName().equals(firstName)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) {
            return true;
        }
        return false;
    }

    //Search by name
    public void searchByName(String firstName) {
        List<Person> streamList = personList.stream().filter(person -> firstName.equals(person.getFirstName())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
    }

    //Search by searchByCity
    public void searchByCity(String city) {
        List<Person> streamList = personList.stream().filter(person -> city.equals(person.getCity())).collect(Collectors.toList());
        System.out.println("Persons in city : " + streamList);
    }

    //Search by searchByState
    public void searchByState(String state) {
        List<Person> streamList = personList.stream().filter(person -> state.equals(person.getState())).collect(Collectors.toList());
        System.out.println("Person in state : " + streamList);
    }

    public void viewByCity(String city1) {
        List<Person> streamList = personList.stream().filter(person -> city1.equals(person.getCity())).collect(Collectors.toList());
        System.out.println("person in city : " + streamList);
        Dictionary cityDetails = new Hashtable();
        for (Person person : personList) {
            if (city1.equals(person.getCity())) {
                cityDetails.put(person.getFirstName(), city1);
            }
        }
        System.out.println("Address book contact details : " + cityDetails);
    }

    public void viewByState(String state1) {
        List<Person> streamList = personList.stream().filter(person -> state1.equals(person.getState())).collect(Collectors.toList());
        System.out.println("Person in state : " + streamList);
        Dictionary stateDetails = new Hashtable();
        for (Person person : personList) {
            if (state1.equals(person.getState())) {
                stateDetails.put(person.getFirstName(), state1);
            }
        }
        System.out.println("Address book contact details : " + stateDetails);
    }

    public void personCountByCity(String city2) {
        int count = (int) personList.stream().filter(person -> city2.equals(person.getCity())).count();
        System.out.println("Total person count in " + city2 + " City is " + count);
    }

    public void  personCountByState(String state2) {
        int count = (int) personList.stream().filter(person -> state2.equals(person.getState())).count();
        System.out.println("Total person count in " + state2 + " City is " + count );
    }

    public void sortByName() {
        List<Person> sortedName = personList.stream().sorted((s1,s2) -> s1.getFirstName().compareToIgnoreCase(s1.getFirstName())).collect(Collectors.toList());
        System.out.println("Sorted person alphabetically : " + sortedName );
    }
}


