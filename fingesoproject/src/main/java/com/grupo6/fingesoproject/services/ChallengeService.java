package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Challenge;
import com.grupo6.fingesoproject.repositories.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Challenge> getAllIdeas(){
        return this.challengeRepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Challenge getChallenge(@PathVariable String id){
        return challengeRepository.findChallengetById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Challenge> deleteChallenge (@PathVariable String id){
        Challenge challenge = challengeRepository.findChallengetById(id);
        if(challenge == null){
            return  new ResponseEntity<Challenge>(challenge, HttpStatus.NOT_FOUND);
        }
        challengeRepository.delete(challenge);
        return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Challenge createChallenge(@RequestBody Challenge challenge){
        return challengeRepository.save(challenge);
    }
}
