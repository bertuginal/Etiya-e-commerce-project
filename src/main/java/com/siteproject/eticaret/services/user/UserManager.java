package com.siteproject.eticaret.services.user;

import com.siteproject.eticaret.core.utilities.mapping.ModelMapperService;
import com.siteproject.eticaret.core.utilities.result.Result;
import com.siteproject.eticaret.dtos.request.user.CreateUserDto;
import com.siteproject.eticaret.dtos.request.user.DeleteUserDto;
import com.siteproject.eticaret.dtos.request.user.UpdateUserDto;
import com.siteproject.eticaret.dtos.response.user.GetAllUsersDto;
import com.siteproject.eticaret.dtos.response.user.GetUserByIdDto;
import com.siteproject.eticaret.entities.User;
import com.siteproject.eticaret.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {


    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result addUser(CreateUserDto createUserDto) {
        User userToAdd = User.builder()
                .userEmail(createUserDto.getUserEmail())
                .userPassword(createUserDto.getUserPassword())
                .createdDate(new Date())
                .isActive(true)
                .build();
        userRepository.save(userToAdd);
        return new Result(true, "User has been successfully added!");
    }

    @Override
    public Result deleteUser(DeleteUserDto deleteUserDto) {
        User user = userRepository.findById(deleteUserDto.getUserId()).orElseThrow();
        user.setIsActive(false);
        user.setUpdatedDate(new Date());
        userRepository.save(user);
        return new Result(true, "User has been successfully deleted!");
    }

    @Override
    public Result updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getUserId()).orElseThrow();
        user.setIsActive(false);
        userRepository.save(user);

        User userToUpdate = User.builder()

                .userEmail(updateUserDto.getUserEmail() == null ? user.getUserEmail() : updateUserDto.getUserEmail())
                .userPassword(updateUserDto.getUserPassword() == null ? user.getUserPassword() : updateUserDto.getUserPassword())
                .isActive(true)
                .createdDate(user.getCreatedDate())
                .updatedDate(new Date())
                .build();
        userRepository.save(userToUpdate);
        return new Result(true, "User has been successfully updated!");
    }

    @Override
    public Result<GetUserByIdDto> getUserById(GetUserByIdDto getUserByIdDto) {
        User userId = userRepository.findById(getUserByIdDto.getUserId()).orElseThrow();
        GetUserByIdDto response = modelMapperService.forResponse().map(userId, GetUserByIdDto.class);
        return new Result<GetUserByIdDto>(true, response);
    }

    @Override
    public Result<List<GetAllUsersDto>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<GetAllUsersDto> response = userList.stream().map(user -> modelMapperService.forResponse().map(user, GetAllUsersDto.class)).collect(Collectors.toList());
        return new Result<List<GetAllUsersDto>>(true, "All users were showed!", response);
    }
}
