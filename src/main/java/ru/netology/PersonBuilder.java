package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder() {
    }

    private boolean hasAge() {
        if (age < 0) {
            return false;
        }
        return true;
    }

    private boolean hasAddress() {
        if (city == null) {
            return false;
        }
        return true;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (name == null && surname == null) {
            throw new IllegalStateException();
        }
        if (hasAge() && hasAddress()) {
            return new Person(name, surname, age, city);
        }
        else if (hasAddress()) {
            return new Person(name, surname, city);
        }
        else if (hasAge()) {
            return new Person(name, surname, age);
        }
        else {
            return new Person(name, surname);
        }
    }
}
