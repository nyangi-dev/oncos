package kro.kr.dyacode.springboottemplate.domain.user.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import kro.kr.dyacode.springboottemplate.domain.user.dto.UserDto;
import kro.kr.dyacode.springboottemplate.domain.user.entity.User;
import kro.kr.dyacode.springboottemplate.domain.user.repository.UserRepository;
import kro.kr.dyacode.springboottemplate.global.common.imageStore.Image;
import kro.kr.dyacode.springboottemplate.global.common.imageStore.ImageUploader;
import kro.kr.dyacode.springboottemplate.global.security.service.JwtTokenService;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ImageUploader imageUploader;
    private final JwtTokenService jwtTokenService;

    // create
    public void create(UserDto.Request userDto) throws Exception {
        String plainPassword = userDto.getPassword();
        String encryptedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        Image image = imageUploader.upload(userDto.getImage(), "user");

        userDto.setPassword(encryptedPassword);
        User user = new User(userDto, image.getStorePath());
        userRepository.save(user);
    }

    // readMe
    public UserDto.Response readMe(String token) throws NotFoundException {
        return new UserDto.Response(userRepository.findById(jwtTokenService.getId(token)).orElseThrow(NotFoundException::new)); 
    }

    // readOne
    public UserDto.Response read(Long id) throws NotFoundException {
        return new UserDto.Response(userRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    // update
    public void update(Long id, UserDto.Request userDto) throws Exception {
        User user = userRepository.findById(id).orElseThrow(NotFoundException::new);
        String plainPassword = userDto.getPassword();
        String encryptedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        Image image = imageUploader.upload(userDto.getImage(), "user");

        userDto.setPassword(encryptedPassword);
        user.update(userDto, image.getStorePath());
        userRepository.save(user);
    }

    // delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    // login
    public String loginAndGetToken(UserDto.Request userDto) throws NotFoundException {
        User user = userRepository.findByEmail(userDto.getEmail()).orElseThrow(NotFoundException::new);
        String bodyPassword = userDto.getPassword();
        String savedPassword = user.getPassword();

        if (!BCrypt.checkpw(bodyPassword, savedPassword)) {
            throw new RuntimeException("wrong password");
        }

        return jwtTokenService.createToken(user.getId());
    }
}