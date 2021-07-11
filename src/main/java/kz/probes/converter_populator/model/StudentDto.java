package kz.probes.converter_populator.model;

import lombok.Data;

@Data
public class StudentDto {
    private String name;
    private String surname;
    private Boolean hasScholarship;
    private String city;
    private String street;
}
