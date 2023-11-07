package kro.kr.dyacode.springboottemplate.domain.user.dto;

import org.springframework.web.multipart.MultipartFile;
import kro.kr.dyacode.springboottemplate.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {
    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Request {
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

        MultipartFile avatar;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Response {
        String id;
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
        public Response (User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.tier = user.getTier();
            this.exp = user.getExp();
            this.limExp = user.getLimExp();
            this.units = user.getUnits();
            this.badges = user.getBadges();
            this.point = user.getPoint();
            this.bgs = user.getBgs();

            this.avatar = user.getAvatar();
        }
    }
}
