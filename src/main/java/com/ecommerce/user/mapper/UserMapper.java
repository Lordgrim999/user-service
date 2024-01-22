package com.ecommerce.user.mapper;


import com.ecommerce.user.DTO.UserDTO;
import com.ecommerce.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    UserDTO mapUserToUserDTO(User user);
    User mapUserDTOTOUser(UserDTO userDTO);
}
