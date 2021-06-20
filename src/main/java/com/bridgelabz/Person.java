package com.bridgelabz;

import java.util.Comparator;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNum;
    private String email;

    public Person(String firstName, String lastName, String address, String city, String state, String zip, String phoneNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Comparator<Person>firstNameSorting = (p1, p2) -> {
        String firstName1 = p1.getFirstName();
        String firstName2= p2.getFirstName();
        return firstName1.compareToIgnoreCase(firstName2);
    };

    public static Comparator<Person> citySorting = (p1, p2) -> {
        String city1 = p1.getCity();
        String city2 = p2.getCity();
        return city1.compareToIgnoreCase(city2);
    };

    public static Comparator<Person> stateSorting = (p1, p2) -> {
        String state1 = p1.getState();
        String state2 = p1.getState();
        return state1.compareToIgnoreCase(state2);
    };

    public static Comparator<Person> zipSorting = (p1, p2) -> {
        String zip1 = p1.getZip();
        String zip2 = p2.getZip();
        return zip1.compareToIgnoreCase(zip2);
    };




    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
