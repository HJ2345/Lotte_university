package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
