package kr.co.greenuniv.service;


import kr.co.greenuniv.dto.StudentDTO;
import kr.co.greenuniv.entity.Student;
import kr.co.greenuniv.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    public void save(StudentDTO studentDto) {

      log.info(">>>저장 된것 :S_name={}", studentDto.getS_name());


        log.info(">>> 저장될 DTO: {}", studentDto);

        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);



    }


}
