package org.example.expert.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.annotation.Auth;
import org.example.expert.domain.common.dto.AuthUser;
import org.example.expert.domain.common.response.ApiResponse;
import org.example.expert.domain.common.response.CommonResponse;
import org.example.expert.domain.user.dto.request.UserChangePasswordRequest;
import org.example.expert.domain.user.dto.response.UserResponse;
import org.example.expert.domain.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{userId}")
    public ApiResponse<UserResponse> getUser(@PathVariable long userId) {
        return ApiResponse.ok(userService.getUser(userId));
    }

    @PutMapping("/users")
    public ApiResponse<CommonResponse> changePassword(
        @Auth AuthUser authUser,
        @RequestBody UserChangePasswordRequest userChangePasswordRequest
    ) {
        return ApiResponse.ok(userService.changePassword(authUser.getId(), userChangePasswordRequest));
    }
}
