package org.example.expert.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.expert.config.PasswordEncoder;
import org.example.expert.domain.common.exception.ExceptionCode;
import org.example.expert.domain.common.exception.InvalidRequestException;
import org.example.expert.domain.common.response.CommonResponse;
import org.example.expert.domain.user.dto.request.UserChangePasswordRequest;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.entity.User;
import org.example.expert.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserResponse getUser(long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new InvalidRequestException(ExceptionCode.USER_NOT_FOUND));
        return new UserResponse(user.getId(), user.getEmail());
    }

    @Transactional
    public CommonResponse changePassword(long userId, UserChangePasswordRequest userChangePasswordRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new InvalidRequestException(ExceptionCode.USER_NOT_FOUND));

        if (passwordEncoder.matches(userChangePasswordRequest.getNewPassword(), user.getPassword())) {
            throw new InvalidRequestException(ExceptionCode.NEW_PASSWORD_SAME_AS_OLD);
        }

        if (!passwordEncoder.matches(userChangePasswordRequest.getOldPassword(), user.getPassword())) {
            throw new InvalidRequestException(ExceptionCode.PASSWORD_INCORRECT);
        }

        user.changePassword(passwordEncoder.encode(userChangePasswordRequest.getNewPassword()));

        return new CommonResponse("비밀번호 수정 완료");
    }
}
