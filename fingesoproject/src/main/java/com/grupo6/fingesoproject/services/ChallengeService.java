package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Challenge;
import com.grupo6.fingesoproject.repositories.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Challenge>> getAllChallenge(){
        return new ResponseEntity<List<Challenge>>(challengeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Challenge> getChallenge(@PathVariable String id){
        if(challengeRepository.findChallengeById(id) == null){
            return new ResponseEntity<Challenge>(challengeRepository.findChallengeById(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Challenge>(challengeRepository.findChallengeById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Challenge> deleteChallenge (@PathVariable String id){
        Challenge challenge = challengeRepository.findChallengeById(id);
        if(challenge == null){
            return  new ResponseEntity<Challenge>(challenge, HttpStatus.NOT_FOUND);
        }
        challengeRepository.delete(challenge);
        return new ResponseEntity<Challenge>(challenge, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge challenge){
        if(challenge.getOwnerBanned() == true){
            return  new ResponseEntity<Challenge>(challenge, HttpStatus.UNAUTHORIZED);
        }
        Calendar today = Calendar.getInstance();
        challenge.setCreationDate(today.getTime());
        challenge.setLastUpdate(today.getTime());
        challengeRepository.save(challenge);
        return new ResponseEntity<Challenge>(challenge, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Challenge> updateChallenge(@PathVariable String id, @RequestBody Challenge updatedChallenge){
        Challenge unUpdatedChallenge = challengeRepository.findChallengeById(id);
        if(unUpdatedChallenge == null){
            return new ResponseEntity<Challenge>(unUpdatedChallenge, HttpStatus.NOT_FOUND);
        }
        /*if(updatedChallenge.getOwnerBanned() == true){
            return  new ResponseEntity<Challenge>(unUpdatedChallenge, HttpStatus.UNAUTHORIZED);
        }*/
        unUpdatedChallenge.setDescription(updatedChallenge.getDescription());
        unUpdatedChallenge.setTitle(updatedChallenge.getTitle());
        Calendar today = Calendar.getInstance();
        unUpdatedChallenge.setLastUpdate(today.getTime());
        unUpdatedChallenge.setOwner(updatedChallenge.getOwner());
        challengeRepository.save(unUpdatedChallenge);
        return new ResponseEntity<Challenge>(unUpdatedChallenge, HttpStatus.OK);
    }
}
