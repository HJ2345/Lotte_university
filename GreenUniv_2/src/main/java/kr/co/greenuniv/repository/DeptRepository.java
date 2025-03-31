package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Department;
import kr.co.greenuniv.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Department, String> {
}
