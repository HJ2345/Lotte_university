package kr.co.greenuniv.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.co.greenuniv.dto.UserDTO;
import kr.co.greenuniv.entity.User;
import kr.co.greenuniv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import kr.co.greenuniv.entity.User;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final HttpServletRequest request;

    public void register(UserDTO userDTO){

        // 엔티티 변환
        User user = modelMapper.map(userDTO, User.class);

        // 저장
        userRepository.save(user);
    }



}
