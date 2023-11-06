package kro.kr.dyacode.springboottemplate.domain.user.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import kro.kr.dyacode.springboottemplate.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
}
