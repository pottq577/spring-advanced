package org.example.expert.domain.auth.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotBlank @Email
    private String email;

    @Size(min = 8, message = "새 비밀번호는 8자 이상이어야 합니다.")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$")
    @NotBlank
    private String password;

    @NotBlank
    private String userRole;
}
