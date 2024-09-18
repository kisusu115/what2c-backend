package com.mop.what2c.user.service;

import com.mop.what2c.user.domain.SignUpDto;
import com.mop.what2c.user.domain.User;
import com.mop.what2c.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(SignUpDto signUpDto) {
        String username = signUpDto.getUsername();
        String password = signUpDto.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if(isExist) return;

        User user = User.builder()
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .build();

        userRepository.save(user);
    }
}
