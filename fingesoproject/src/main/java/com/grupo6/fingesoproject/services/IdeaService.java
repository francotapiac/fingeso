package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Idea;
import com.grupo6.fingesoproject.repositories.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/idea")
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Idea>> getAllIdea(){
        return new ResponseEntity<List<Idea>>(ideaRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Idea> getIdea(@PathVariable String id){
        if(ideaRepository.findIdeaById(id) == null){
            return new ResponseEntity<Idea>(ideaRepository.findIdeaById(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Idea>(ideaRepository.findIdeaById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Idea> deleteService(@PathVariable String id){
        Idea idea = ideaRepository.findIdeaById(id);
        if(idea == null){
            return new ResponseEntity<Idea>(idea, HttpStatus.NOT_FOUND);
        }
        ideaRepository.delete(idea);
        return new ResponseEntity<Idea>(idea, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Idea> createIdea(@RequestBody Idea idea){
        /*if(idea.getOwnerBanned() == true){
            return  new ResponseEntity<Idea>(idea, HttpStatus.UNAUTHORIZED);
        }*/
        Calendar today = Calendar.getInstance();
        idea.setCreationDate(today.getTime());
        idea.setLastUpdate(today.getTime());
        ideaRepository.save(idea);
        return new ResponseEntity<Idea>(idea, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Idea> updateChallenge(@PathVariable String id, @RequestBody Idea updatedIdea){
        Idea unUpdatedIdea = ideaRepository.findIdeaById(id);
        if(unUpdatedIdea == null){
            return new ResponseEntity<Idea>(unUpdatedIdea, HttpStatus.NOT_FOUND);
        }
        /*if(updatedIdea.getOwnerBanned() == true){
            return  new ResponseEntity<Idea>(unUpdatedIdea, HttpStatus.UNAUTHORIZED);
        }*/
        unUpdatedIdea.setDescription(updatedIdea.getDescription());
        unUpdatedIdea.setTitle(updatedIdea.getTitle());
        unUpdatedIdea.setOwner(updatedIdea.getOwner());
        Calendar today = Calendar.getInstance();
        unUpdatedIdea.setLastUpdate(today.getTime());
        ideaRepository.save(unUpdatedIdea);
        return new ResponseEntity<Idea>(unUpdatedIdea, HttpStatus.OK);
    }
    @RequestMapping(path = "/searchByOwner/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Idea>> searchByOwner(@PathVariable String id) {
        System.out.println(id);
        System.out.println(ideaRepository.findIdeaByOwner(id));
        if (ideaRepository.findIdeaByOwner(id).isEmpty() == true) {
            return new ResponseEntity<List<Idea>>(ideaRepository.findIdeaByOwner(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Idea>>(ideaRepository.findIdeaByOwner(id), HttpStatus.OK);
    }
}
