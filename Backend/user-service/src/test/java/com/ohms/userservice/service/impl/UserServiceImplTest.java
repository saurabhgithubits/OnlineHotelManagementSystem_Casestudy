package com.ohms.userservice.service.impl;

import com.ohms.userservice.dto.UserDTO;
import com.ohms.userservice.entity.Role;
import com.ohms.userservice.entity.User;
import com.ohms.userservice.repository.UserRepository;
import com.ohms.userservice.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void loadUserByUsername_UserFound_ReturnsUserDetails() {
        // Arrange
        String username = "test@example.com";
        User user = new User();
        user.setEmail(username);
        user.setPassword("password");

        when(userRepository.findByEmail(username)).thenReturn(Optional.of(user));

        // Act
        var userDetails = userService.userDetailsService().loadUserByUsername(username);

        // Assert
        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
    }

    @Test
    void loadUserByUsername_UserNotFound_ThrowsUsernameNotFoundException() {
        // Arrange
        String username = "nonexistent@example.com";

        when(userRepository.findByEmail(username)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(UsernameNotFoundException.class, () ->
                userService.userDetailsService().loadUserByUsername(username));
    }

    @Test
    void addUser_ValidUser_ReturnsUserWithPasswordMasked() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        // Act
        User resultUser = userService.addUser(user);

        // Assert
        assertEquals("******", resultUser.getPassword());
    }

   
    @Test
    void convertUserDTO2User_ValidUserDTO_ReturnsUserWithMatchingFields() {
        // Arrange
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setFirstName("John");
        userDTO.setLastName("Doe");
        userDTO.setEmail("john.doe@example.com");
        userDTO.setPassword("password");
        userDTO.setRole(Role.DEVELOPER);

    
        User resultUser = userService.convertUserDTO2User(userDTO);

        
        assertEquals(userDTO.getId(), resultUser.getId());
        assertEquals(userDTO.getFirstName(), resultUser.getFirstName());
        assertEquals(userDTO.getLastName(), resultUser.getLastName());
        assertEquals(userDTO.getEmail(), resultUser.getEmail());
        assertEquals(userDTO.getPassword(), resultUser.getPassword());
        assertEquals(userDTO.getRole(), resultUser.getRole());
    }
}
