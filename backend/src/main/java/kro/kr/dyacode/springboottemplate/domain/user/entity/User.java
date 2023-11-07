package kro.kr.dyacode.springboottemplate.domain.user.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import kro.kr.dyacode.springboottemplate.domain.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Getter
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(unique = true)
    String email;
    String name;
    String password;
    Integer tier;
    Integer exp;
    Integer limExp;
    String units;
    String badges;
    Integer point;
    String bgs;

    String avatar;

    public User (UserDto.Request userDto, String avatar) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.tier = userDto .getTier();
        this.exp = userDto.getExp();
        this.limExp = userDto.getLimExp();
        this.units = userDto.getUnits();
        this.badges = userDto.getBadges();
        this.point = userDto.getPoint();
        this.bgs = userDto.getBgs();

        this.avatar = avatar;
    }
    
    public void update (UserDto.Request userDto, String avatar) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.tier = userDto .getTier();
        this.exp = userDto.getExp();
        this.limExp = userDto.getLimExp();
        this.units = userDto.getUnits();
        this.badges = userDto.getBadges();
        this.point = userDto.getPoint();
        this.bgs = userDto.getBgs();

        this.avatar = avatar;
    }
}
