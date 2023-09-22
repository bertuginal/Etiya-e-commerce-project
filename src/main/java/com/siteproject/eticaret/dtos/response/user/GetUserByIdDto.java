package com.siteproject.eticaret.dtos.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdDto {

    private int userId;
    private String userEmail;
    private String userPassword;
    private boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}
