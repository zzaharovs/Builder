package ru.netology;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String address;



    PersonBuilder () {

        age = -1;
        address = "Unknown";

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

            throw new IllegalArgumentException("Возраст должен быть или равен нолю, или больше ноля");

        }

        this.age = age;
        return this;

    }

    public PersonBuilder setAddress(String address) {

        this.address = address;
        return this;

    }

    public Person build() {

        if (this.name == null) {
            throw new IllegalStateException("Не заполнено обязательное поле 'Имя'");
        } else if (this.surname == null) {
            throw new IllegalStateException("Не заполнено обязательное поле 'Фамилия'");
        }

        return new Person(this.name, this.surname, this.age, this.address);
    }
}
