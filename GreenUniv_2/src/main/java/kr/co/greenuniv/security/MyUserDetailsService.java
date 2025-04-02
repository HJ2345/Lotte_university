package kr.co.greenuniv.security;

import kr.co.greenuniv.entity.User;
import kr.co.greenuniv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username : {}", username);

        // 사용자 조회
        Optional<User> optUser = userRepository.findById(username);

        if(optUser.isPresent()){
            // Security 사용자 인증객체 생성
            MyUserDetails myUserDetails = MyUserDetails.builder()
                    .user(optUser.get())  // User 객체에서 사용자 정보를 MyUserDetails로 변환
                    .build();

            // 리턴되는 myUserDetails는 Security ContextHolder에 저장
            return myUserDetails;
        }

        // 사용자 없음 -> 예외 던지기
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
