package kr.co.greenuniv.repository;

import kr.co.greenuniv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    long countByUid(String uid);
    long countByEmail(String email);
    long countByHp(String hp);
}
