package kro.kr.dyacode.springboottemplate.domain.unit.service;

import kro.kr.dyacode.springboottemplate.domain.unit.dto.UnitDto;
import kro.kr.dyacode.springboottemplate.domain.unit.entity.Unit;
import kro.kr.dyacode.springboottemplate.domain.unit.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // search
    public List<Unit> search(String word) {
        return unitRepository.findByName(word);
    }

    // update
    public void update(String id, UnitDto.Request unitDto) throws Exception {
        Unit unit = unitRepository.findById(id).orElseThrow(NotFoundException::new);
        unitRepository.save(unit);
    }

    // delete
    public void delete(String id) {
        unitRepository.deleteById(id);
    }
}
