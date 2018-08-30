package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Idea;
import com.grupo6.fingesoproject.repositories.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/idea")
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Idea> getAllIdea(){
        return ideaRepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Idea getIdea(@PathVariable String id){
        return ideaRepository.findIdeaById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Idea> deleteService(@PathVariable String id){
        Idea idea = ideaRepository.findIdeaById(id);
        if(idea == null){
            return new ResponseEntity<Idea>(idea, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Idea>(idea, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Idea createIdea(@RequestBody Idea idea){
        return ideaRepository.save(idea);
    }
}
