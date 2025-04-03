package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Professor;
import kr.co.greenuniv.entity.University;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessorRepository extends JpaRepository<Professor,String> {

    @Query("SELECT MAX(p.P_num) FROM Professor p WHERE p.P_num LIKE :prefix%")
    String findMaxPNumWithPrefix(@Param("prefix") String prefix);


    // ProfessorRepository
    int countByDepartment_DeptNo(String deptNo);

 


}


