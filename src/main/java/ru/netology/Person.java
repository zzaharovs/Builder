package ru.netology;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {

    private final String name;
    private final String surname;
    private int age;
    private String address;

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

            setAge();

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

    private void setAge() {

        System.out.println("Возраст не задан! Необходимо установить возраст");

        while (true) {

            try {

                System.out.println("Введите целое число больше нуля");
                Scanner scan = new Scanner(System.in);
                int age = scan.nextInt();

                if (age >= 0) {

                    this.age = age;
                    break;

                }

            } catch (InputMismatchException ignored) {

            }
        }
    }

    public void happyBirthday() {

        if (!hasAge()) {
            setAge();
        }

        this.age++;

    }

    public PersonBuilder newChildBuilder() {

        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAddress(this.address);

        return child;

    }

    @Override
    public String toString() {

        String ageInfo = hasAge() ? String.valueOf(age) : "неизвестен";
        String townInfo = hasAddress() ? "города " + address : "неизвестного города";

        return name + " " + surname + " из " + townInfo + ", возраст " + ageInfo;
    }
}
