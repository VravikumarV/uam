package com.techgaints.plugins.uam.config;

import org.springframework.data.repository.CrudRepository;

public enum UserStatus {
    ACTIVE,
    DEACTIVATED,
    UNREGISTERED;

    private UserStatus(){
    }
}
