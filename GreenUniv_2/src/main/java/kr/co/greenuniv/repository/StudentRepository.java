package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT MAX(s.S_num) FROM Student s WHERE s.S_num LIKE CONCAT(:prefix, '%')")
    String findLatestStudentNum(@Param("prefix") String prefix);

    // 특정 학년 + 상태별 수
    long countByAdmissionGradeAndStatus(String admissionGrade, String status);

    // StudentRepository.java
    long countByStatus(String status); // status 값: "재학", "휴학", "졸업", "대학원"


    long countByDepartment_DeptNameAndStatus(String deptName, String status);

    long countByDepartment_DeptNoAndStatus(String deptNo, String status);

    int countByDepartment_DeptNo(String deptNo); // 학과별 학생 수


}
