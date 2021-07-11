package kz.probes.converter_populator;

import kz.probes.converter_populator.model.StudentDto;
import kz.probes.converter_populator.model.StudentModel;

public class AddressPopulator implements Populator<StudentModel, StudentDto>{

    @Override
    public void populate(StudentModel studentModel, StudentDto studentDto) {
        studentDto.setCity(studentModel.getCity());
        studentDto.setStreet(studentModel.getStreet());
    }

}
