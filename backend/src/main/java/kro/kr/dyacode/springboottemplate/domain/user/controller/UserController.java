package kro.kr.dyacode.springboottemplate.domain.user.controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kro.kr.dyacode.springboottemplate.domain.user.dto.UserDto;
import kro.kr.dyacode.springboottemplate.domain.user.dto.TokenDto;
import kro.kr.dyacode.springboottemplate.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@ModelAttribute UserDto.Request userDto) throws Exception {
        userService.create(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/@me")
    public ResponseEntity<?> readMe(@RequestHeader(name = "Authorization") String token) throws NotFoundException {
        UserDto.Response userDto = userService.readMe(token);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody UserDto.Request userDto) throws NotFoundException {
        String userToken = userService.loginAndGetToken(userDto);
        TokenDto tokenDto = new TokenDto();

        tokenDto.setToken(userToken);
        return new ResponseEntity<>(tokenDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(name = "id") Long id) throws NotFoundException {
        UserDto.Response userDto = userService.read(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable(name = "id") Long id, UserDto.Request userDto)
            throws Exception {
        userService.update(id, userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") Long id)
            throws Exception {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}