package com.bridgelabz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    Scanner scanner = new Scanner(System.in);
    public  void addressBookServices(Contacts contacts) {
        Scanner scanner = new Scanner(System.in);
        int choice, i = 0;
        while (i == 0) {
            System.out.println("Your choice for contact");
            System.out.println("1 : Add new person");
            System.out.println("2 : Display Details");
            System.out.println("3 : Edit person detail");
            System.out.println("4 : delete person");
            System.out.println("5 : search by name");
            System.out.println("6 : search by city");
            System.out.println("7 : search by state");
            System.out.println("8 : view by city");
            System.out.println("9 : view by state");
            System.out.println("10 : person Count By City");
            System.out.println("11 :person Count By state");
            System.out.println("12 : Sort Details");
            System.out.println("13 : Exit");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    contacts.addDetails();
                    break;
                case 2:
                    contacts.displayDetails();
                    break;
                case 3:
                    contacts.editDetails();
                    break;
                case 4:
                    System.out.println("Enter a name to delete");
                    String firstName1 = scanner.next();
                    contacts.deleteDetails(firstName1);
                case 5:
                    String firstName = scanner.next();
                    contacts.searchByName(firstName);
                    break;
                case 6:
                    String city = scanner.next();
                    contacts.searchByCity(city);
                    break;
                case 7:
                    String State = scanner.next();
                    contacts.searchByState(State);
                    break;
                case 8:
                    String city1 = scanner.next();
                    contacts.viewByCity(city1);
                    break;
                case 9:
                    String state1 = scanner.next();
                    contacts.viewByState(state1);
                    break;
                case 10:
                    String city2 = scanner.next();
                    contacts.personCountByCity(city2);
                    break;
                case 11:
                    String state2 = scanner.next();
                    contacts.personCountByState(state2);
                    break;
                case 12:
                    contacts.sortDetails();
                    break;
                case 13:
                    i = -1;
                    break;
                default:
                    System.out.println("Please select valid option");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program");
        Map<String, Contacts> addressBookMap = new HashMap<String, Contacts>();
        String addressBookName;
        while (true) {
            System.out.println("Enter the addressBook name");
            addressBookName = scanner.nextLine();
            Contacts contacts = addressBookMap.get(addressBookName);
            if (contacts == null) {
                contacts = new Contacts();
                addressBookMap.put(addressBookName, contacts);
            }
        AddressBookMain addressBook = new AddressBookMain();
        addressBook.addressBookServices(contacts);
            addressBook.addressBookJson();
                System.out.println("press 1 : want to enter in other addressBook");
            System.out.println("press other key to exit");
            String choice = scanner.nextLine();
            if(!choice.equals("1"))
                break;
        }
    }

    public void addressBookJson() {
        System.out.println("1. Write data into json");
        System.out.println("2. Read data from json");
        int choice1 = scanner.nextInt();
        switch (choice1) {
            case 1:
                try {
                    AddressBookJSON.writeDataToJSon();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    AddressBookJSON.readDataFromJson();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("invalid");
        }
    }
}