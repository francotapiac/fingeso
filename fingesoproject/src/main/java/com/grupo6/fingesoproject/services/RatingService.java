package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Rating;
import com.grupo6.fingesoproject.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/rating")
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Rating>> getAllRating(){
        return new ResponseEntity<List<Rating>>(ratingRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Rating> getRating(@PathVariable String id){
        if(ratingRepository.findRatingById(id) == null){
            return new ResponseEntity<Rating>(ratingRepository.findRatingById(id), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Rating>(ratingRepository.findRatingById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Rating> deleteRating(@PathVariable String id){
        Rating rating = ratingRepository.findRatingById(id);
        if(rating == null){
            return new ResponseEntity<Rating>(rating, HttpStatus.NOT_FOUND);
        }
        ratingRepository.delete(rating);
        return new ResponseEntity<Rating>(rating, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        if(rating.getOwnerBanned() == true){
            return  new ResponseEntity<Rating>(rating, HttpStatus.UNAUTHORIZED);
        }
        Calendar today = Calendar.getInstance();
        rating.setCreationDate(today.getTime());
        rating.setLastUpdate(today.getTime());
        ratingRepository.save(rating);
        return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Rating> updateChallenge(@PathVariable String id, @RequestBody Rating updatedRating){
        Rating unUpdatedRating = ratingRepository.findRatingById(id);
        if(unUpdatedRating == null){
            return new ResponseEntity<Rating>(unUpdatedRating, HttpStatus.NOT_FOUND);
        }
        /*if(updatedRating.getOwnerBanned() == true){
            return  new ResponseEntity<Rating>(unUpdatedRating, HttpStatus.UNAUTHORIZED);
        }*/
        unUpdatedRating.setValue(updatedRating.getValue());
        unUpdatedRating.setIdea(updatedRating.getIdea());
        unUpdatedRating.setOwner(updatedRating.getOwner());
        Calendar today = Calendar.getInstance();
        unUpdatedRating.setLastUpdate(today.getTime());
        ratingRepository.save(unUpdatedRating);
        return new ResponseEntity<Rating>(unUpdatedRating, HttpStatus.OK);
    }
}
