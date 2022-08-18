package com.bitcamp221.didabara.controller;
import com.bitcamp221.didabara.model.UserEntity;
import com.bitcamp221.didabara.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bitcamp221.didabara.dto.ResponseDTO;
import com.bitcamp221.didabara.dto.UserDTO;
import com.bitcamp221.didabara.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private TokenProvider tokenProvider;

    //  회원가입
//  http://localhost:8080/auth/signup


    //  로그인
//  http://localhost:8080/auth/signin
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        UserEntity user = userService.getByCredentials(
                userDTO.getUsername(),
                userDTO.getPassword(),
                passwordEncoder
        );

        if (user != null) {
//    토큰 생성.
            final String token = tokenProvider.create(user);

            final UserDTO responsUserDTO = UserDTO.builder()
                    .username(user.getUsername())
                    .id(user.getId())
                    .token(token)
                    .build();

            return ResponseEntity.ok().body(responsUserDTO);
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login Failed")
                    .build();

            return ResponseEntity.badRequest().body(responseDTO);
        }

    }


    //프론트에서 인가코드 받아오는 url
    /* 카카오 로그인 */
    @GetMapping("/kakao")
    public ResponseEntity<?> kakaoCallback(String code) {
        log.info("code={}", code);

        String access_Token = userService.getKaKaoAccessToken(code);
        userService.createKakaoUser(access_Token);

        return ResponseEntity.ok().body(access_Token);
    }

    // https://kauth.kakao.com/oauth/authorize?client_id=4af7c95054f7e1d31cff647965678936&redirect_uri=http://localhost:8080/auth/kakao&response_type=code

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
//      받은 데이터 유효성 검사
            if (userDTO == null || userDTO.getPassword() == null) {
                throw new RuntimeException("Invalid Password value");
            }


//      요청을 이용해 저장할 유저 객체 생성
            UserEntity userEntity = UserEntity.builder()
                    .username(userDTO.getUsername())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .nickname(userDTO.getNickname())
                    .registDate(LocalDate.now())
//              .password(userDTO.getPassword())
                    .build();

//      서비스를 이용해 리포지터리에 유저 저장
            UserEntity registeredUser = userService.creat(userEntity);

//      응답객체 만들기(패스워드 제외)
            UserDTO responseUserDTO = UserDTO.builder()
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .nickname(registeredUser.getNickname())
                    .build();

//      유저 정보는 현재 하나이므로 리스트로 만들 필요 없음
//      ResponseDTO를 사용하지 않고 UserDTO 타입으로 반환

            return ResponseEntity.ok().body(responseUserDTO);

        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();

            return ResponseEntity.badRequest().body(responseDTO);
        }

    }

    @PutMapping
    public Optional<UserEntity> updateUser(@RequestBody UserEntity userEntity)throws Exception{

        Optional<UserEntity> updatedUser = userService.update(userEntity.getId());
        return updatedUser;



    }


//    @PostMapping("update")
//    public ResponseEntity<?> UpdateUser(@RequestBody UserDTO userDTO) {
//        try {
////      받은 데이터 유효성 검사
//            if (userDTO == null || userDTO.getPassword() == null) {
//                throw new RuntimeException("Invalid value");
//            }
//
//
//        } catch (Exception e) {
//            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
//
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//
//        return null;
//    }
}