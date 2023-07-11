package com.techgaints.plugins.uam.controller;

import com.techgaints.plugins.uam.model.mongo.MUser;
import com.techgaints.plugins.uam.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Validated
//@ValidateOnExecution
@RequestMapping("/uam")
public class UserSignUpController {

    @Autowired
    UserService userService;

    @Operation(summary = "To create a User", description = "To create user in UAM")
    @ApiResponse(description = "This gives response for User Creation", responseCode = "200",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = MUser.class)) })
    @PostMapping("/user")   //http://localhost:8282/kyc/uam/user
    public com.techgaints.plugins.uam.model.mongo.MUser createUser(@RequestBody com.techgaints.plugins.uam.model.mongo.MUser mUser) {
        log.info("createUser:  "+mUser.toString());
        com.techgaints.plugins.uam.model.mongo.MUser userInfo = userService.createUser(mUser);
        return userInfo;
    }

    @Operation(summary = "To update a User", description = "To update user in UAM")
    @ApiResponses(value = {
    @ApiResponse(description = "This gives response for User updationn", responseCode = "200",
            content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id User",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @PutMapping("/user")
    public MUser udpateUser(@RequestBody MUser user) {
        log.info(user.toString());
        MUser userInfo = userService.updateUser(user);
        return user;
    }

    @Operation(summary = "To get a User", description = "To get user in UAM")
    @ApiResponses(value = {
            @ApiResponse(description = "This gives response for give User Id", responseCode = "200",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id User",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/user/{userId}")   //http://localhost:8181/kyc/uam/user/56
    public MUser getUser(@PathVariable String userId) {
        return userService.getUser(userId).get();
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable String userId) {
        log.info(userId.toString());
        userService.deleteUser(userId);
    }


}
