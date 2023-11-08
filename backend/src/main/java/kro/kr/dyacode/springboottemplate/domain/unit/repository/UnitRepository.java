package kro.kr.dyacode.springboottemplate.domain.unit.repository;

import kro.kr.dyacode.springboottemplate.domain.unit.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, String> {
    Optional<Unit> findBySkill (String skill);
}
