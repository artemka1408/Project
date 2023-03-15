package com.example.projectmanager.entity.enums;

public enum Permission {
    EDIT_DATA("ADMIN"),
    READ_DATA("SIMPLE_USER");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
