package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Idea;
import com.grupo6.fingesoproject.repositories.IdeaRepository;
import com.grupo6.fingesoproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(value = "/idea")
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;
    private UserRepository userRepository;

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
        if (ideaRepository.findIdeaByOwner(id).isEmpty() == true) {
            return new ResponseEntity<List<Idea>>(ideaRepository.findIdeaByOwner(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Idea>>(ideaRepository.findIdeaByOwner(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/searchByDescription/{title}/{description}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Idea>> searchByDescription(@PathVariable String title, @PathVariable String description) {
        if(title.equals("") && description.equals("")){
            return new ResponseEntity<List<Idea>>(ideaRepository.findAll(), HttpStatus.OK);
        }
        if(!ideaRepository.findByDescription(description).isEmpty() == true) {
            return new ResponseEntity<List<Idea>>(ideaRepository.findByDescriptionLike(description), HttpStatus.OK);
        }
        if(!ideaRepository.findByTitle(title).isEmpty()){
            return new ResponseEntity<List<Idea>>(ideaRepository.findByTitle(title), HttpStatus.OK);
        }
        if(!ideaRepository.findByTitleLike(title).isEmpty()){
            return new ResponseEntity<List<Idea>>(ideaRepository.findByTitleLike(title), HttpStatus.OK);
        }
        if(!ideaRepository.findByDescriptionLike(description).isEmpty() == true) {
            return new ResponseEntity<List<Idea>>(ideaRepository.findByDescriptionLike(description), HttpStatus.OK);
        }
        return new ResponseEntity<List<Idea>>(ideaRepository.findByDescriptionLike(description), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{id}/{idUser}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Idea> deleteService(@PathVariable String id, @PathVariable String idUser){
        Idea idea = ideaRepository.findIdeaById(id);
        if(ideaRepository.findByOwner(id) != userRepository.findUserById(idUser)){
            return new ResponseEntity<Idea>(idea, HttpStatus.FORBIDDEN);
        }
        if(idea == null){
            return new ResponseEntity<Idea>(idea, HttpStatus.NOT_FOUND);
        }
        ideaRepository.delete(idea);
        return new ResponseEntity<Idea>(idea, HttpStatus.OK);
    }

}
