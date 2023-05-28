package com.example.microserviceuab.mapper;

import com.example.microserviceuab.domain.User;
import com.example.microserviceuab.dto.UserCreationRequestDto;
import com.example.microserviceuab.dto.UserCreationResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userCreationRequestDtoToUser(UserCreationRequestDto dto);

    UserCreationResponseDto userToUserCreationResponseDto(User user);

}
