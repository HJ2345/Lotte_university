package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department, String> {
    @Query("SELECT d.deptNo FROM Department d ORDER BY d.deptNo DESC LIMIT 1")
    String findTopDeptNo();

    Department findByDeptName(String deptName);

    Department findByDeptNo(String deptNo);
}

