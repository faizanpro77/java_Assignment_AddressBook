package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class Contacts {

    Scanner scanner = new Scanner(System.in);
    public static final List<Person> personList = new ArrayList<>();
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

    public static void sortByName(List<Person> person) {
        person.sort(Person.firstNameSorting);
        person.forEach(System.out::println);
    }

    public static void sortByCity(List<Person> peron) {
        peron.sort(Person.citySorting);
        peron.forEach(System.out::println);
    }

    public static void sortByState(List<Person> person) {
        person.sort(Person.stateSorting);
        person.forEach(System.out::println);
    }

    public static void sortByZip(List<Person> person) {
        person.sort(Person.zipSorting);
        person.forEach(System.out::println);
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

        int choice = 0, i = 0;
        while (i == 0) {
            System.out.println("select option  to edit contact details:");
            System.out.println("1 for  first name:");
            System.out.println("2 for  last name:");
            System.out.println("3 for address:");
            System.out.println("4 for city:");
            System.out.println("5 for state:");
            System.out.println("6 for  zip number:");
            System.out.println("7 for phone number:");
            System.out.println("8 for email:");
            System.out.println("9 for save and exit:");

            List<Person> personList;
            choice = Integer.valueOf(scanner.next());
            System.out.println("your choice for edit details : " + choice);
            switch (choice) {
                case 1:
                    System.out.print("Enter old first name : ");
                    String firstName = String.valueOf(scanner.next());
                    personList = searchByName(firstName);
                    System.out.print("Enter new first name : ");
                    firstName = String.valueOf(scanner.next());
                    personList.get(0).setFirstName(firstName);
                    break;

                case 2:
                    System.out.print("Enter old lastName : ");
                    String lastName = String.valueOf(scanner.next());
                    personList = searchByLastName(lastName);
                    System.out.print("Enter new lastName : ");
                    lastName = String.valueOf(scanner.next());
                    personList.get(0).setLastName(lastName);
                    break;

                case 3:
                    System.out.print("Enter old address : ");
                    String address = String.valueOf(scanner.next());
                    personList = searchByAddress(address);
                    System.out.print("Enter new address : ");
                    address = String.valueOf(scanner.next());
                    personList.get(0).setAddress(address);
                    break;

                case 4:
                    System.out.print("Enter old city : ");
                    String city = String.valueOf(scanner.next());
                    personList = searchByCity(city);
                    System.out.print("Enter new city : ");
                    city = String.valueOf(scanner.next());
                    personList.get(0).setCity(city);
                    break;

                case 5:
                    System.out.print("Enter old state : ");
                    String state = String.valueOf(scanner.next());
                    personList = searchByState(state);
                    System.out.print("Enter new state : ");
                    city = String.valueOf(scanner.next());
                    personList.get(0).setCity(state);
                    break;

                case 6:

                    System.out.print("Enter old zip : ");
                    String zip = String.valueOf(scanner.next());
                    personList = searchByZip(zip);
                    System.out.print("Enter new zip : ");
                    zip = String.valueOf(scanner.next());
                    personList.get(0).setCity(zip);
                    break;

                case 7:
                    System.out.print("Enter old phoneNum : ");
                    String phoneNum = String.valueOf(scanner.next());
                    personList = searchByPhoneNum(phoneNum);
                    System.out.print("Enter new phoneNum : ");
                    phoneNum = String.valueOf(scanner.next());
                    personList.get(0).setCity(phoneNum);
                    break;

                case 8:

                    System.out.print("Enter old email : ");
                    String email = String.valueOf(scanner.next());
                    personList = searchByEmail(email);
                    System.out.print("Enter new email : ");
                    email = String.valueOf(scanner.next());
                    personList.get(0).setCity(email);
                    break;

                case 9:
                    i = 1;
                    break;
                default:
                    System.out.println("select valid option");
                    break;
            }
        }
    }

    public void deleteDetails(String firstname) {
        String deleteName;
        for (Person contact : personList) {
            deleteName = contact.getFirstName();
            System.out.println(deleteName);
            if (firstname.equalsIgnoreCase(deleteName)) {
                personList.remove(contact);
            }
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
    public List<Person> searchByName(String firstName) {
        List<Person> streamList = personList.stream().filter(person -> firstName.equals(person.getFirstName())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
        return streamList;
    }

    public List<Person> searchByLastName(String lastName) {
        List<Person> streamList = personList.stream().filter(person -> lastName.equals(person.getLastName())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
        return streamList;
    }

    //Search by searchByCity
    public List<Person> searchByCity(String city) {
        List<Person> streamList = personList.stream().filter(person -> city.equals(person.getCity())).collect(Collectors.toList());
        System.out.println("Persons in city : " + streamList);
        return streamList;
    }

    //Search by searchByState
    public List<Person> searchByState(String state) {
        List<Person> streamList = personList.stream().filter(person -> state.equals(person.getState())).collect(Collectors.toList());
        System.out.println("Person in state : " + streamList);
        return streamList;
    }

    public List<Person> searchByZip(String zip) {
        List<Person> streamList = personList.stream().filter(person -> zip.equals(person.getAddress())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
        return streamList;
    }

    public List<Person> searchByPhoneNum(String phoneNum) {
        List<Person> streamList = personList.stream().filter(person -> phoneNum.equals(person.getAddress())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
        return streamList;
    }

    public List<Person> searchByEmail(String email) {
        List<Person> streamList = personList.stream().filter(person -> email.equals(person.getAddress())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
        return streamList;
    }

    public List<Person> searchByAddress(String address) {
        List<Person> streamList = personList.stream().filter(person -> address.equals(person.getAddress())).collect(Collectors.toList());
        System.out.println("Persons details : " + streamList);
        return streamList;
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

    public void sortDetails() {
        System.out.println("1 : sort alphabetically By Name");
        System.out.println("2 : sort by city");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sortByName(personList);
                break;
            case 2:
                sortByCity(personList);
                break;
            case 3:
                sortByState(personList);
                break;
            case 4:
                sortByZip(personList);
                break;
            default:
                System.out.println("select valid option");
        }
    }
}


