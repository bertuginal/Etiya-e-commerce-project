package com.siteproject.eticaret.controller;

import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.user.CreateUserDto;
import com.siteproject.eticaret.dtos.request.user.DeleteUserDto;
import com.siteproject.eticaret.dtos.request.user.UpdateUserDto;
import com.siteproject.eticaret.dtos.response.user.GetAllUsersDto;
import com.siteproject.eticaret.dtos.response.user.GetUserByIdDto;
import com.siteproject.eticaret.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public Result addUser(@Valid @RequestBody CreateUserDto createUserDto) {
        return this.userService.addUser(createUserDto);
    }

    @PutMapping("/deleteuser")
    public Result deleteUser(@Valid @RequestBody DeleteUserDto deleteUserDto) {
        return this.userService.deleteUser(deleteUserDto);
    }

    @PutMapping("/updateuser")
    public Result updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
        return this.userService.updateUser(updateUserDto);
    }

    @GetMapping("/getuserbyid")
    public Result<GetUserByIdDto> getUserById(@RequestBody GetUserByIdDto getUserByIdDto) {
        return this.userService.getUserById(getUserByIdDto);
    }
    @GetMapping("/getallusers")
    public Result<List<GetAllUsersDto>> getAllUsers(){
        return this.userService.getAllUsers();
    }
}
