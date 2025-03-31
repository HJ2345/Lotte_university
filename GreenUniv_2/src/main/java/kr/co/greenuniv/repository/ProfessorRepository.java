package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
