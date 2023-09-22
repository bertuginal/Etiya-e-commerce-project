package com.siteproject.eticaret.dtos.request.user;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    @NotNull
    private int userId;

    @Nullable
    @Size(min = 2)
    private String userName;

    @Nullable
    @Email
    private String userEmail;

    @Nullable
    @Size(min = 8, max = 12, message = "User Password must be between 8 and 12 characters!")
    private String userPassword;
}
