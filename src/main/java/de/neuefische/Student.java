package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private int ID;
    private String name;
    private int postalCode;
    private int age;

}
