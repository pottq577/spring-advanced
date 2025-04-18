package org.example.expert.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.response.ApiResponse;
import org.example.expert.domain.common.response.CommonResponse;
import org.example.expert.domain.user.dto.request.UserRoleChangeRequest;
import org.example.expert.domain.user.service.UserAdminService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAdminController {

    private final UserAdminService userAdminService;

    @PatchMapping("/admin/users/{userId}")
    public ApiResponse<CommonResponse> changeUserRole(
        @PathVariable long userId,
        @RequestBody UserRoleChangeRequest userRoleChangeRequest
    ) {
        return ApiResponse.ok(userAdminService.changeUserRole(userId, userRoleChangeRequest));
    }
}
