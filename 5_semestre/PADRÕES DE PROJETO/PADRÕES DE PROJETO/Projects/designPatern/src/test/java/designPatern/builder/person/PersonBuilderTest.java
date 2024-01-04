/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designPatern.builder.person;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author andre
 */
public class PersonBuilderTest {

    @Test
    public void shouldBuildPersonWithPartialData() {

        String firstName = "André";
        String midleName = "Luis";
        String lastName = "Quiosi";

        PersonBuilder builder = new PersonBuilder();

        Person person = builder.firstName(firstName)
                .midleName(midleName)
                .lastName(lastName)
                .build();

        assertTrue(person.getFirstName().equals(firstName));
        assertTrue(person.getMidleName().equals(midleName));
        assertTrue(person.getLastName().equals(lastName));

    }

    @Test
    public void shouldBuildPersonWithFullData() {
        String firstName = "André";
        String midleName = "Luis";
        String lastName = "Quiosi";
        String gender = "M";
        String motherFullName = "Maria Aparecida";
        String fatherFullName = "Adilson";
        LocalDate birthDate = LocalDate.of(1996, Month.MARCH, 5);
        float heightInCentimeters = 184;
        float weightInKilograms = 74;
        String ethnicity = "Branca";
        String specialCharacteristics = "Aluno de TSI";

        PersonBuilder builder = new PersonBuilder();
        Person person = builder
                .firstName(firstName)
                .midleName(midleName)
                .lastName(lastName)
                .gender(gender)
                .motherFullName(motherFullName)
                .fatherFullName(fatherFullName)
                .birthDate(birthDate)
                .heightInCentimeters(heightInCentimeters)
                .weightInKilograms(weightInKilograms)
                .ethnicity(ethnicity)
                .specialCharacteristics(specialCharacteristics)
                .build();

        assertTrue(person.getFirstName().equals(firstName));
        assertTrue(person.getMidleName().equals(midleName));
        assertTrue(person.getLastName().equals(lastName));
        assertTrue(person.getBirthDate().compareTo(birthDate)==0);
        

    }

}
