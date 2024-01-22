package com.ecommerce.user.service;

import com.ecommerce.user.DTO.UserDTO;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.mapper.UserMapper;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> fetchAllUsers() {
        List<User> restaurants=  userRepository.findAll();
        return restaurants.stream().map(UserMapper.INSTANCE::mapUserToUserDTO).collect(Collectors.toList());
    }

    public UserDTO fetchRestaurantById(String id) {
        return UserMapper.INSTANCE.mapUserToUserDTO(userRepository.findById(Integer.parseInt(id)).get());
    }

    public UserDTO saveUser(UserDTO userDTO) {
        return UserMapper.INSTANCE.mapUserToUserDTO(userRepository.save(UserMapper.INSTANCE.mapUserDTOTOUser(userDTO)));
    }
}
