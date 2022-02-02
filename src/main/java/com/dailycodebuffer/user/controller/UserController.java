package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.UserX;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public UserX saveUser(@RequestBody UserX user){
        log.info("inside saveUser method in user controller");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){
        log.info("inside getUserWithDepartment method in user controller");
        return userService.getUserWithDepartment(id);
    }
    @GetMapping("/user/{id}")
    public UserX getUserBuId(@PathVariable Long id){
        return userRepository.findById(id).get();
    }
}
