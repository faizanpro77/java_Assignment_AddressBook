package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public  void addressBookServices(Contacts contacts) {
        Scanner scanner = new Scanner(System.in);
        int choice, i = 0;
        while (i == 0) {
            System.out.println("Your choice for contact");
            System.out.println("1 : Add new person");
            System.out.println("2 : Display Details");
            System.out.println("3 : Edit person detail");
            System.out.println("4 : delete person");
            System.out.println("5 : Exit");

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
                    contacts.deleteDetails();
                case 5:
                    i = -1;
                    break;
                default:
                    System.out.println("Please enter valid scanner");
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
            System.out.println("press 1 : want to enter in other addressBook");
            System.out.println("press other key to exit");
            String choice = scanner.nextLine();
            if(!choice.equals("1"))
                break;
        }
    }
}