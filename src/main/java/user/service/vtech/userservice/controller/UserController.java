package user.service.vtech.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import user.service.vtech.userservice.VO.ResponseTemplateVO;
import user.service.vtech.userservice.entity.User;
import user.service.vtech.userservice.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Executing SaveUser in the controller");
        return userService.saveUser(user);
    }


    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Executing getUserWithDepartment in the controller");
        return userService.getUserWithDepartment(userId);
    }
}
