package kro.kr.dyacode.springboottemplate.domain.unit.controller;

import kro.kr.dyacode.springboottemplate.domain.unit.dto.UnitDto;
import kro.kr.dyacode.springboottemplate.domain.unit.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/unit")
@RestController
@RequiredArgsConstructor
public class UnitController {
    private final UnitService unitService;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody UnitDto.Request unitDto) {
        unitService.create(unitDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") String id) throws NotFoundException {
        UnitDto.Response unitDto = unitService.read(id);
        return new ResponseEntity<>(unitDto, HttpStatus.OK);
    }
}
