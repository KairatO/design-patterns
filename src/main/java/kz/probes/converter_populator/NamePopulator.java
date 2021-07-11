package kz.probes.converter_populator;

import kz.probes.converter_populator.model.StudentDto;
import kz.probes.converter_populator.model.StudentModel;

public class NamePopulator implements Populator<StudentModel, StudentDto>{

    @Override
    public void populate(StudentModel studentModel, StudentDto studentDto) {
        studentDto.setName(studentModel.getName());
        studentDto.setSurname(studentModel.getSurname());
    }
}
