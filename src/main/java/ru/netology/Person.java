package ru.netology;

public class Person {

    private final String name;
    private final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = -1;
        this.address = "Unknown";
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }


    public boolean hasAge() {

        return this.age != -1;

    }

    public boolean hasAddress() {

        return !this.address.equals("Unknown");

    }

    public String getName() {

        return name;

    }

    public String getSurname() {

        return surname;

    }

    public int getAge() {

        if (!hasAge()) {
            throw new IllegalStateException("Возраст не указан!");
        }

        return age;
    }

    public String getAddress() {

        if (!hasAddress()) {

            return "адрес неизвестен";

        }

        return address;
    }

    public void setAddress(String address) {

        this.address = address;

    }


    public void happyBirthday() {

        if (!hasAge()) {
            throw new IllegalStateException("Возраст не указан!");
        }

        this.age++;

    }

    public PersonBuilder newChildBuilder() {

        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.address);

    }

    @Override
    public String toString() {

        String ageInfo = hasAge() ? String.valueOf(age) : "неизвестен";
        String townInfo = hasAddress() ? "города " + address : "неизвестного города";

        return name + " " + surname + " из " + townInfo + ", возраст " + ageInfo;
    }
}
