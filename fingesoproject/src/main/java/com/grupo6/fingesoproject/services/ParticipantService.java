package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Participant;
import com.grupo6.fingesoproject.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/participant")
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Participant> getAllParticipant(){
        return participantRepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Participant getParticipant(@PathVariable String id){
        return participantRepository.findParticipantById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Participant> deleteParticipant(@PathVariable String id){
        Participant participant = participantRepository.findParticipantById(id);
        if(participant == null){
            return new ResponseEntity<Participant>(participant, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Participant>(participant, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Participant createParticipant(@RequestBody Participant participant){
        return participantRepository.save(participant);
    }
}
