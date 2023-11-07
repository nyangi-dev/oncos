package kro.kr.dyacode.springboottemplate.domain.unit.entity;

import jakarta.persistence.*;
import kro.kr.dyacode.springboottemplate.domain.unit.dto.UnitDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity()
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Unit {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    Integer custom;
    String logo;
    String name;
    String skill;
    String owner;
    String users;
    String steps;
    Integer score;

    public Unit (UnitDto.Request unitDto) {
        this.custom = unitDto.getCustom();
        this.logo = unitDto.getLogo();
        this.name = unitDto.getName();
        this.skill = unitDto.getSkill();
        this.owner = unitDto.getOwner();
        this.users = unitDto.getUsers();
        this.steps = unitDto.getSteps();
        this.score = unitDto.getScore();
    }
}
