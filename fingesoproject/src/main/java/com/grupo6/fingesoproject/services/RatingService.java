package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Rating;
import com.grupo6.fingesoproject.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rating")
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Rating> getAllRating(){
        return ratingRepository.findAll();
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Rating getRating(@PathVariable String id){
        return ratingRepository.findRatingById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Rating> deleteRating(@PathVariable String id){
        Rating rating = ratingRepository.findRatingById(id);
        if(rating == null){
            return new ResponseEntity<Rating>(rating, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Rating createRating(@RequestBody Rating rating){
        return ratingRepository.save(rating);
    }
}
