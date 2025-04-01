package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnivRepository extends JpaRepository<University, String> {
    List<University> findAll();
}
