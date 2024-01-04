package designPatern.builder.person;

import java.time.LocalDate;

public class PersonBuilder {

    private String firstName = "";
    private String midleName = "";
    private String lastName = "";
    private String gender = "";
    private String motherFullName = "";
    private String fatherFullName = "";
    private LocalDate birthDate = null;
    private float heightInCentimeters = Float.NaN;
    private float weightInKilograms = Float.NaN;
    private String ethnicity = "";
    private String specialCharacteristics = "";

    public PersonBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder midleName(String midleName) {
        this.midleName = midleName;
        return this;
    }

    public PersonBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonBuilder motherFullName(String motherFullName) {
        this.motherFullName = motherFullName;
        return this;
    }

    public PersonBuilder fatherFullName(String fatherFullName) {
        this.fatherFullName = fatherFullName;
        return this;
    }

    public PersonBuilder birthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PersonBuilder heightInCentimeters(float heightInCentimeters) {
        this.heightInCentimeters = heightInCentimeters;
        return this;
    }

    public PersonBuilder weightInKilograms(float weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
        return this;
    }

    public PersonBuilder ethnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public PersonBuilder specialCharacteristics(String specialCharacteristics) {
        this.specialCharacteristics = specialCharacteristics;
        return this;
    }
    
    public Person build(){
        Person person = new Person();
        
        person.setBirthDate(birthDate);
        person.setEthnicity(ethnicity);
        person.setFatherFullName(fatherFullName);
        person.setFirstName(firstName);
        person.setGender(gender);
        person.setHeightInCentimeters(heightInCentimeters);
        person.setLastName(lastName);
        person.setMidleName(midleName);
        person.setMotherFullName(motherFullName);
        person.setSpecialCharacteristics(specialCharacteristics);
        person.setWeightInKilograms(weightInKilograms);
        
        return person;
    }
    
}
