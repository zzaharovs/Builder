package ru.netology;


public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        Person man = new PersonBuilder()
                .setName("Константин")
                .setSurname("Карамзин")
                .setAge(33)
                .build();

        System.out.println("Есть женщина " + mom + " у которой есть сын: " + son);

        System.out.println("_______________________________________________________");

        //Празднуем день рождения мамы
        System.out.println("Вчера " + mom.getName() + " было " + mom.getAge());
        mom.happyBirthday();
        System.out.println("Сегодня " + mom.getName() + " уже " + mom.getAge());

        System.out.println("_______________________________________________________");

        try {
            // Пробуем получить возраст у сына
            son.getAge();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("_______________________________________________________");


        //Смотрим в каком городе живет Константин

        System.out.println("У них есть знакомый " + man.getName() + " " + man.getSurname());
        System.out.println("Место жительства " + man.getName() + ": " + man.getAddress());
        man.setAddress("Токио");
        System.out.println("А теперь он переехал в другой город и получил прописку");
        System.out.println("Теперь " + man.getName() + " живет в " + man.getAddress());

        System.out.println("_______________________________________________________");
        try {
            // Проверяем на нехватку обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("_______________________________________________________");

        try {
            // Проверяем на допустимость возраста
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}