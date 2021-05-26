package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain
{

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBook addressBook = new AddressBook();
        Scanner option = new Scanner(System.in);
        System.out.println("Your choice for contact");
        System.out.println("1 for add");
        System.out.println("2 for edit");
        System.out.println("3 for delete");
        int choice = option.nextInt();
        switch (choice) {
            case 1:
                addressBook.add();
                break;
            case 2:
                addressBook.edit();
                break;
            case 3:
                addressBook.delete();
        }
    }
}
