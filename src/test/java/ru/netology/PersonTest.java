package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonTest {


    @Test
    public void testHappyBirthdayHasAgeTrue() {

        //given

        final int age = 19;
        final int expectedResult = age + 1;

        final Person testPerson = new Person("Ivan", "Ivanov", age, "Unknown");



        //then

        testPerson.happyBirthday();

        //when

        Assertions.assertEquals(testPerson.getAge(), expectedResult);

    }

}
