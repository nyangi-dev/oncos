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
        String username;
        String password;

        MultipartFile image;
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Response {
        String email;
        String username;

        String imagePath;
        public Response (User user) {
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.imagePath = user.getImagePath();
        }
    }
}
