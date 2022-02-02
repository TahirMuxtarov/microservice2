package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser method in user service");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        log.info("inside getUserWithDepartment method in user service");
        ResponseTemplateVO templateVO = new ResponseTemplateVO();
        User user = userRepository.findById(id).get();
        Department department = restTemplate.getForObject("localhost:8088/departments/"+user.getDepartmentId(),Department.class);
        templateVO.setUser(user);
        templateVO.setDepartment(department);
        return templateVO;
    }
}
