package com.bridgelabz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import static com.bridgelabz.Contacts.personList;

public class AddressBookJSON {
    public static void writeDataToJSon() throws IOException {
        {
            Path filePath = Paths.get("Person.json");
            Gson gson = new Gson();
            String json = gson.toJson(personList);
            FileWriter writer = new FileWriter(String.valueOf(filePath));
            writer.write(json);
            writer.close();
        }
    }

    public static void readDataFromJson() throws IOException {
        ArrayList<Person> personList = null;
        Path filePath = Paths.get("Person.json");
        try (Reader reader = Files.newBufferedReader(filePath);) {
            Gson gson = new Gson();
            personList = new ArrayList<Person>(Arrays.asList(gson.fromJson(reader, Person[].class)));
            for (Person person : personList) {
                System.out.println("Firstname : " + person.getFirstName());
                System.out.println("Lastname : " + person.getLastName());
                System.out.println("Address : " + person.getAddress());
                System.out.println("City : " + person.getCity());
                System.out.println("State : " + person.getState());
                System.out.println("Zip Code : " + person.getZip());
                System.out.println("Phone number : " + person.getPhoneNum());
                System.out.println("Email : " + person.getEmail());
            }
        }
    }
}