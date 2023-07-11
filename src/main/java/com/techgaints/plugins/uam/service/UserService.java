package com.techgaints.plugins.uam.service;

import com.techgaints.plugins.uam.model.mongo.MUser;
import com.techgaints.plugins.uam.repository.jpa.UserRepository;
import com.techgaints.plugins.uam.repository.mongo.IMUserDataRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IMUserDataRepository imUserDataRepository;

    //@Transactional
    //@CircuitBreaker(name = "createUser", fallbackMethod = "fallBackCreateUser")
    public com.techgaints.plugins.uam.model.mongo.MUser createUser(com.techgaints.plugins.uam.model.mongo.MUser muser) {
        log.info("UserService.createUser:  "+muser.toString());
        com.techgaints.plugins.uam.model.mongo.MUser mongoUser = imUserDataRepository.save(muser);
        log.info("Mongo createUser:  "+mongoUser.getId());
        return mongoUser;
    }

    public MUser updateUser(MUser user) {
        log.info(user.toString());
        MUser userInfo = imUserDataRepository.save(user);
        return userInfo;
    }
        public MUser fallBackCreateUser(MUser user, Throwable t) {
        log.info("Fallback for createUser, Throwable =  "+t.getMessage());
        log.info("Fallback for createUser:  "+user.toString());
        return user;
    }

    @CircuitBreaker(name = "getUser", fallbackMethod = "fallBackGetUser")
    public Optional<MUser> getUser(@RequestParam String userId) {
        Optional<com.techgaints.plugins.uam.model.mongo.MUser> mongoUser = imUserDataRepository.findById(userId);
        log.info("Mongo User ;  "+mongoUser.isPresent(), mongoUser.get().toString());
        return mongoUser;
    }

    public Optional<MUser> fallBackGetUser(String userId, Throwable t) {
        log.info("Fallback for getUser, Throwable =  "+t.getMessage());
        log.info("Fallback for getUser:  "+userId);
        return Optional.of(MUser.builder().id(userId).build());
    }


    public void deleteUser(String userId) {
        Optional<MUser> mUser = imUserDataRepository.findById(userId);
        imUserDataRepository.delete(mUser.get());
    }

}
