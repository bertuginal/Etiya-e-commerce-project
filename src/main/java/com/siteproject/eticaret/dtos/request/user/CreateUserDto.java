package com.siteproject.eticaret.dtos.request.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotEmpty
    @Size(min = 2)
    private String userName;

    @Email
    @NotBlank
    private String userEmail;

    @NotNull
    @Size(min = 8, max = 12, message = "User password must be between 8 and 12 characters!")
    private String userPassword;
}
