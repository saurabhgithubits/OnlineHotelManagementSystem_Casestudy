package com.ohms.userservice.util;

import com.ohms.userservice.entity.Role;
import com.ohms.userservice.exception.InvalidRoleException;

public class RoleValidator {
    public static void validateRole(String role) {
        try {
            Role.valueOf(role);
        } catch (IllegalArgumentException e) {
            throw new InvalidRoleException("Invalid role: " + role);
        }
    }
}
