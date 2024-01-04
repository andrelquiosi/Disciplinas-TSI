/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designPatern.builder.person;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author andre
 */
public class PersonTest {

    final String firstName = "";
    final String midleName = "";
    final String lastName = "";

    @Test
    public void shouldReturnCorrectFullName() {
        PersonBuilder builder = new PersonBuilder();

        Person person = builder.firstName(firstName)
                .midleName(midleName)
                .lastName(lastName)
                .build();
        
        String expectedFullName = firstName + " " + midleName + " " + lastName;
        String obtainedFullName = person.getFullName();
        
        assertTrue(expectedFullName.equals(obtainedFullName));
    }
    
        @Test
    public void shouldReturnCorrectFullNameWithoutMidleName() {
        PersonBuilder builder = new PersonBuilder();

        Person person = builder.firstName(firstName)
                .lastName(lastName)
                .build();
        
        String expectedFullName = firstName + " " + lastName;
        String obtainedFullName = person.getFullName();
        
        assertTrue(expectedFullName.equals(obtainedFullName));
    }

}
