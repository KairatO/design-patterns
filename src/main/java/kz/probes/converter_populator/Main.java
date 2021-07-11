package kz.probes.converter_populator;

import kz.probes.converter_populator.model.StudentDto;
import kz.probes.converter_populator.model.StudentModel;

public class Main {
    public static void main(String[] args) {
        StudentModel studentKairat = new StudentModel();
        studentKairat.setName("Kairat");
        studentKairat.setCity("Almaty");
        studentKairat.setGraduatedSchool("44");
        studentKairat.setId(17381);
        studentKairat.setSurname("Adilbekov");
        studentKairat.setStreet("Mailin");
        studentKairat.setHasScholarship(true);

        StudentModel studentOlzhas = new StudentModel();
        studentOlzhas.setName("Olzhas");
        studentOlzhas.setCity("Almaty");
        studentOlzhas.setGraduatedSchool("44");
        studentOlzhas.setId(17382);
        studentOlzhas.setSurname("Ahmetov");
        studentOlzhas.setStreet("Furmanov");
        studentOlzhas.setHasScholarship(false);

        StudentConverter<StudentModel, StudentDto> converter = new StudentConverter<>(StudentDto.class);

        converter
                .addPopulator(new NamePopulator())
                .addPopulator(new HasScholarshipPopulator())
                .addPopulator(new AddressPopulator());

        StudentDto kairatDto = converter.convert(studentKairat);
        System.out.println(kairatDto);

        StudentDto olzhasDto = converter.convert(studentOlzhas);
        System.out.println(olzhasDto);

    }
}
