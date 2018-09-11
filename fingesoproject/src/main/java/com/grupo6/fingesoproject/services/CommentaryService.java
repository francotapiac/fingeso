package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Commentary;
import com.grupo6.fingesoproject.repositories.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(value = "/commentary")
public class CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Commentary>> getAllCommentary(){
        return new ResponseEntity<List<Commentary>>(commentaryRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Commentary> getCommentary(@PathVariable String id){
        if(commentaryRepository.findCommentaryById(id) == null){
            return new ResponseEntity<Commentary>(commentaryRepository.findCommentaryById(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Commentary>(commentaryRepository.findCommentaryById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}" ,method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Commentary> deleteCommentary(@PathVariable String id){
        Commentary commentary = commentaryRepository.findCommentaryById(id);
        if(commentary == null){
            return new ResponseEntity<Commentary>(commentary, HttpStatus.NOT_FOUND);
        }
        commentaryRepository.delete(commentary);
        return new ResponseEntity<Commentary>(commentary, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Commentary> createCommentary(@RequestBody Commentary commentary){
        /*if(commentary.getOwnerBanned() == true){
            return  new ResponseEntity<Commentary>(commentary, HttpStatus.UNAUTHORIZED);
        }*/
        Calendar today = Calendar.getInstance();
        commentary.setCreationDate(today.getTime());
        commentary.setLastUpdate(today.getTime());
        commentaryRepository.save(commentary);
        return new ResponseEntity<Commentary>(commentary, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Commentary> updateChallenge(@PathVariable String id, @RequestBody Commentary updatedCommentary){
        Commentary unUpdatedCommentary = commentaryRepository.findCommentaryById(id);
        if(unUpdatedCommentary == null){
            return new ResponseEntity<Commentary>(unUpdatedCommentary, HttpStatus.NOT_FOUND);
        }
        if(updatedCommentary.getOwnerBanned() == true){
            return  new ResponseEntity<Commentary>(unUpdatedCommentary, HttpStatus.UNAUTHORIZED);
        }
        unUpdatedCommentary.setText(updatedCommentary.getText());
        unUpdatedCommentary.setOwner(updatedCommentary.getOwner());
        unUpdatedCommentary.setIdea(updatedCommentary.getIdea());
        Calendar today = Calendar.getInstance();
        unUpdatedCommentary.setLastUpdate(today.getTime());

        commentaryRepository.save(unUpdatedCommentary);
        return new ResponseEntity<Commentary>(unUpdatedCommentary, HttpStatus.OK);
    }
}
