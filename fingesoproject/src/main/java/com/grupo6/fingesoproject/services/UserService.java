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
        /*if(updatedUser.getBanned() == true){
            return  new ResponseEntity<User>(unUpdatedUser, HttpStatus.UNAUTHORIZED);
        }*/

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

    /*@RequestMapping(path = "/searchUser/{firstName}/{lastName}/{email}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> get_findByLastNameAndFirstName(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String email){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println("###");
        System.out.println(userRepository.findAllByLastNameAndFirstNameAndEmail(lastName, firstName, email));
        System.out.println(userRepository.findAllByLastNameOrFirstNameOrEmail(lastName,firstName, email));
        System.out.println("-------------------------------------------------");
        if(userRepository.findAllByLastNameAndFirstNameAndEmail(lastName, firstName, email).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findAllByLastNameAndFirstNameAndEmail(lastName, firstName, email), HttpStatus.OK);
        }
        System.out.println("1");
        if(userRepository.findAllByEmailOrFirstNameOrLastName(email, firstName, lastName).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findAllByEmailOrFirstNameOrLastName(email, firstName, lastName), HttpStatus.OK);
        }
        System.out.println("2");
        if(userRepository.findAllByLastNameOrFirstNameOrEmail(lastName,firstName, email).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findAllByLastNameOrFirstNameOrEmail(lastName, firstName, email), HttpStatus.OK);
        }
        System.out.println("3");
        if(userRepository.findByLastNameOrFirstName(lastName, firstName).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findByLastNameOrFirstName(lastName, firstName), HttpStatus.OK);
        }
        System.out.println("4");
        if(userRepository.findAllByEmail(email).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findAllByEmail(email), HttpStatus.OK);
        }
        if(userRepository.findAllByFirstName(firstName).isEmpty() == false){

        }
        if(userRepository.findAllByLastName(lastName).isEmpty() == false){

        }
        /*
        if(userRepository.findAllByFirstNameOrEmail(firstName, email).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findAllByFirstNameOrEmail(firstName, email), HttpStatus.OK);
        }
        if(userRepository.findAllByLastNameOrEmail(lastName, email).isEmpty() == false){
            return new ResponseEntity<List<User>>(userRepository.findAllByLastNameOrEmail(lastName, email), HttpStatus.OK);
        }
        System.out.println("NOOOOOT FOUND");
        return new ResponseEntity<List<User>>(userRepository.findAllByLastNameOrFirstNameOrEmail(lastName,firstName, email), HttpStatus.NOT_FOUND);

    }*/

}

