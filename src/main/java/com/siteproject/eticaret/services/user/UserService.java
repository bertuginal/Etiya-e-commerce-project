package com.siteproject.eticaret.services.user;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.user.CreateUserDto;
import com.siteproject.eticaret.dtos.request.user.DeleteUserDto;
import com.siteproject.eticaret.dtos.request.user.UpdateUserDto;
import com.siteproject.eticaret.dtos.response.user.GetAllUsersDto;
import com.siteproject.eticaret.dtos.response.user.GetUserByIdDto;

import java.util.List;

public interface UserService {

    Result addUser(CreateUserDto createUserDto);
    Result deleteUser(DeleteUserDto deleteUserDto);
    Result updateUser(UpdateUserDto updateUserDto);
    Result<GetUserByIdDto> getUserById(GetUserByIdDto getUserByIdDto);
    Result<List<GetAllUsersDto>> getAllUsers();
}
