package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain
{

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contacts contacts = new Contacts();
        Scanner option = new Scanner(System.in);
        int choice, i = 0;
        while (i == 0) {
            System.out.println("Your choice for contact");
            System.out.println("1 : Add new person");
            System.out.println("2 : Display Details");
            System.out.println("3 : Edit person detail");
            System.out.println("4 : delete person");
            System.out.println("5 : Exit");

            choice = option.nextInt();
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
                    System.out.println("Please enter valid option");
            }
        }
    }
}
