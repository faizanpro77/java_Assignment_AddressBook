package com.bridgelabz;

import java.util.Scanner;

public class AddressBook {

    Contact contact =new Contact();
    Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        System.out.println("Enter city");
        String city = scanner.nextLine();
        System.out.println("Enter state");
        String state = scanner.nextLine();
        System.out.println("Enter zip number");
        String zip = scanner.nextLine();
        System.out.println("Enter phone number");
        String phoneNum = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setAddress(address);
        contact.setCity(city);
        contact.setState(state);
        contact.setZip(zip);
        contact.setPhoneNum(phoneNum);
        contact.setEmail(email);
        }
    public boolean edit() {
        System.out.println("Enter first Name");
        String firstName = scanner.next();
        if (firstName.equals(contact.getFirstName())) {
            return false;
        }
        System.out.println("edit details:");
        System.out.println("1 for  first name:");
        System.out.println("2 for  last name:");
        System.out.println("3 for address:");
        System.out.println("4 for city:");
        System.out.println("5 for state:");
        System.out.println("6 for  zip number:");
        System.out.println("7 for phone number:");
        System.out.println("8 for email:");
        int choice = Integer.valueOf(scanner.next());
        System.out.println("your choice for edit details : "+choice);
        switch (choice) {
            case 1:
                contact.setFirstName(scanner.next());
                break;
            case 2:
                contact.setLastName(scanner.next());
                break;
            case 3:
                contact.setAddress(scanner.next());
                break;
            case 4:
                contact.setCity(scanner.next());
                break;
            case 5:
                contact.setState(scanner.next());
                break;
            case 6:
                contact.setZip(scanner.next());
                break;
            case 7:
                contact.setPhoneNum(scanner.next());
                break;
            case 8:
                contact.setEmail(scanner.next());
                break;
            default:
                System.out.println("invalid number" );
        }
        return true;
    }
        public void delete() {
            System.out.println("press 1 for delete");
            System.out.println("press 2 exit");
            int choice1 = Integer.valueOf(scanner.next());
            switch (choice1) {
                case 1:
                    System.out.println("Enter first Name to delete");
                    String firstName2 = scanner.next();
                    if (contact != null && firstName2.equals(contact.getFirstName())) {
                        contact = null;
                    }
                    break;
                case 2:
                    break;
            }
        }
}


