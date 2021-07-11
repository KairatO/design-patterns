package kz.probes.converter_populator.model;

import lombok.Data;

@Data
public class StudentModel {
    private Integer id;
    private String name;
    private String surname;
    private Boolean hasScholarship;
    private String city;
    private String street;
    private String passportId;
    private String graduatedSchool;
}
