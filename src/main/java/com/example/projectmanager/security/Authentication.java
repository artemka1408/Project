package com.example.projectmanager.security;

import com.example.projectmanager.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Value
@Builder
public class Authentication {
    private Long id;

    private Long userId;

    private Role role;

    public boolean hasRole(Role role) {
        return this.role.equals(role);
    }
}
