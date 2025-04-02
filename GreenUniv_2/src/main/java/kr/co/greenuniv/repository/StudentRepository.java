package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT MAX(s.S_num) FROM Student s WHERE s.S_num LIKE CONCAT(:prefix, '%')")
    String findLatestStudentNum(@Param("prefix") String prefix);
}
