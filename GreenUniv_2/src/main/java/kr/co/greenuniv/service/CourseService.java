package kr.co.greenuniv.service;


import kr.co.greenuniv.dto.CourseDTO;
import kr.co.greenuniv.entity.Course;
import kr.co.greenuniv.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;
    private final ModelMapper modelMapper;


    public void save(CourseDTO courseDto) {

        log.info(">>> 저장될 DTO: {}", courseDto);


        Course course = modelMapper.map(courseDto, Course.class);
        courseRepository.save(course);
    }

}
