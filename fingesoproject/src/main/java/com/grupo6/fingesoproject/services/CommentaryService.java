package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Commentary;
import com.grupo6.fingesoproject.repositories.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/commentary")
public class CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Commentary> getAllCommentary(){
        return commentaryRepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Commentary getCommentary(@PathVariable String id){
        return commentaryRepository.findCommentaryById(id);
    }

    @RequestMapping(path = "/{id}" ,method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Commentary> deleteCommentary(@PathVariable String id){
        Commentary commentary = commentaryRepository.findCommentaryById(id);
        if(commentary == null){
            return new ResponseEntity<Commentary>(commentary, HttpStatus.NOT_FOUND);
        }
        commentaryRepository.delete(commentary);
        return new ResponseEntity<Commentary>(commentary, HttpStatus.OK)
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Commentary createCommentary(@RequestBody Commentary commentary){
        return commentaryRepository.save(commentary);
    }
}
