package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("SELECT MAX(c.cor_code) FROM Course c WHERE c.cor_code LIKE :prefix%")
    String findMaxCorCodeWithPrefix(@Param("prefix") String prefix);


    int countByDepartment_DeptNo(String deptNo); // 학과별 강의 수


}
