package kro.kr.dyacode.springboottemplate.domain.unit.dto;

import kro.kr.dyacode.springboottemplate.domain.unit.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UnitDto {
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Request {
        Integer custom;
        String logo;
        String name;
        String skill;
        String owner;
        String users;
        String steps;
        Integer score;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Response {
        String id;
        Integer custom;
        String logo;
        String name;
        String skill;
        String owner;
        String users;
        String steps;
        Integer score;
        public Response (Unit unit) {
            this.id = unit.getId();
            this.custom = unit.getCustom();
            this.logo = unit.getLogo();
            this.name = unit.getName();
            this.skill = unit.getSkill();
            this.owner = unit.getOwner();
            this.users = unit.getUsers();
            this.steps = unit.getSteps();
            this.score = unit.getScore();
        }
    }
}
