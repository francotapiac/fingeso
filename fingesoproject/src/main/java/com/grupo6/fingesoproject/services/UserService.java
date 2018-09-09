package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.User;
import com.grupo6.fingesoproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable String id){
        if(userRepository.findUserById(id) == null){
            return new ResponseEntity<User>(userRepository.findUserById(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(userRepository.findUserById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<User> deleteUser(@PathVariable String id){
        User user = userRepository.findUserById(id);
        if(user == null){
            return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user){
        User oldUser = userRepository.findUserByEmail(user.getEmail());
        if(oldUser == null) {
            Calendar today = Calendar.getInstance();
            user.setLastUpdate(today.getTime());
            user.setCreationDate(today.getTime());
            userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser){
        User unUpdatedUser = userRepository.findUserById(id);
        if(unUpdatedUser == null){
            return new ResponseEntity<User>(unUpdatedUser, HttpStatus.NOT_FOUND);
        }
        unUpdatedUser.setFirstName(updatedUser.getFirstName());
        unUpdatedUser.setLastName(updatedUser.getLastName());
        unUpdatedUser.setEmail(updatedUser.getEmail());
        unUpdatedUser.setPassword(updatedUser.getPassword());
        unUpdatedUser.setRol(updatedUser.getRol());
        unUpdatedUser.setBanned(updatedUser.getBanned());
        Calendar today = Calendar.getInstance();
        unUpdatedUser.setLastUpdate(today.getTime());
        userRepository.save(unUpdatedUser);
        return new ResponseEntity<User>(unUpdatedUser, HttpStatus.OK);
    }
}
