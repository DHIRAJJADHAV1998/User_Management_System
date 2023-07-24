package com.example.crud.crud.controller;
import com.example.crud.crud.exceptionHandlePackage.PersonExceptionHandle;
import com.example.crud.crud.model.User;
import com.example.crud.crud.repository.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserInfo userInfo;
    @PostMapping("/user")
    public User addUsera(@RequestBody User newUser){
        return userInfo.save(newUser);
    }
    @GetMapping("/getUsers")
    public List<User> getAllUser(){
        return userInfo.findAll();
    }
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id){

        return userInfo.findById(id)
                .orElseThrow(()->new PersonExceptionHandle(id));
    }
    @PutMapping("/putUser/{id}")
    public User putUser(@RequestBody User newUser,@PathVariable Long id){
        return userInfo.findById(id)
                .map(user->{
user.setEmail(newUser.getEmail());
user.setName(newUser.getName());
user.setUsername(newUser.getUsername());
return userInfo.save(user);
                }
                )
                .orElseThrow(()->new PersonExceptionHandle(id));
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){

        if(!userInfo.existsById(id)){
          throw new PersonExceptionHandle(id);
        }
        userInfo.deleteById(id);
        return "deleted successfully";
    }
}