//package io.kodlama.hrms.api;
//
//import io.kodlama.hrms.business.abstracts.UserService;
//import io.kodlama.hrms.core.utilities.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping({"/api/users"})
//public class UsersController {
//    private UserService userService;
//
//    @Autowired
//    public UsersController(UserService userService) {
//        super();
//        this.userService = userService;
//    }
//
//    @GetMapping({"/getall"})
//    public List<User> getAll() {
//        return this.userService.getAll();
//    }
//
//    @GetMapping("/getbyemail")
//    public User getByEmail(@RequestParam String email){
//        return userService.getByEmail(email);
//    }
//}