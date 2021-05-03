package ru.netology;

import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        if (age < 0) {
            return false;
        }
        return true;
    }

    public boolean hasAddress() {
        if (city == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        if (hasAge()) {
            return age;
        }
        else throw new IllegalStateException();
    }

    public String getAddress() {
        if (hasAddress()) {
            return city;
        }
        else throw new IllegalStateException();
    }

    public void setAddress(String address) {
        city = address;
    }
    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
        else throw new IllegalStateException();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(surname);
        childBuilder.setAge(0);
        if (hasAddress()) {
            childBuilder.setAddress(city);
        }
        return childBuilder;
    }

    @Override
    public String toString() {
        return name + " " + surname +
                " (age = " + age +
                ", city - " + city + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}
