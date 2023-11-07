package kro.kr.dyacode.springboottemplate.domain.unit.service;

import kro.kr.dyacode.springboottemplate.domain.unit.dto.UnitDto;
import kro.kr.dyacode.springboottemplate.domain.unit.entity.Unit;
import kro.kr.dyacode.springboottemplate.domain.unit.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;

    // create
    public void create(UnitDto.Request unitDto) {
        Unit unit = new Unit(unitDto);
        unitRepository.save(unit);
    }

    // readOne
    public UnitDto.Response read(String id) throws NotFoundException {
        return new UnitDto.Response(unitRepository.findById(id).orElseThrow(NotFoundException::new));
    }
}
