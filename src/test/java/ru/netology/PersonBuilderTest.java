package ru.netology;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonBuilderTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 12, 100})
    public void testSetAge(int age) {

        //given

        final Person testPerson;
        final int expectedResult = age;

        final String name = "Ivan";
        final String surname = "Ivanov";

        //then

        testPerson = new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .setAge(age)
                .build();

        //when

        Assertions.assertEquals(expectedResult, testPerson.getAge());


    }


    @Test

    public void testNonNameInBuilder_IAException () {

        //given

        PersonBuilder testPerson = new PersonBuilder();

        testPerson.setSurname("Ivanov");

        //then

        //when

        assertThrows(IllegalArgumentException.class, testPerson::build);

    }

    @Test
    public void testNonSurnameInBuilder_IAException () {

        //given

        PersonBuilder testPerson = new PersonBuilder();

        testPerson.setName("Ivan");

        //then

        //when

        assertThrows(IllegalArgumentException.class, testPerson::build);

    }

    @Test
    public void testNegativeNumberSetAge_IAException () {

        //given

        PersonBuilder testPerson = new PersonBuilder();

        //then

        int negativeNumberAge = -100;

        //when

        assertThrows(IllegalArgumentException.class,
                () -> testPerson.setAge(negativeNumberAge));

    }


}
