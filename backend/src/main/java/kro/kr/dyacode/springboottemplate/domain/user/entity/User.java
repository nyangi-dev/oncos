package kro.kr.dyacode.springboottemplate.domain.user.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import kro.kr.dyacode.springboottemplate.domain.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity()
@Getter
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(unique = true)
    String email;
    String username;
    String password;

    String imagePath;

    public User (UserDto.Request userDto, String imagePath) {
        this.username = userDto.getUsername();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.imagePath = imagePath;
    }
    
    public void update (UserDto.Request userDto, String imagePath) {
        this.username = userDto.getUsername();
        this.email = userDto.getEmail();
        this.password = userDto.getPassword();
        this.imagePath = imagePath;
    }
}
