package kro.kr.dyacode.springboottemplate.domain.unit.repository;

import kro.kr.dyacode.springboottemplate.domain.unit.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, String> {}
