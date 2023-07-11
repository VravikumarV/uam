package com.techgaints.plugins.uam.repository.jpa;


import com.techgaints.plugins.uam.model.jpa.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPreferences, Long> {

}
