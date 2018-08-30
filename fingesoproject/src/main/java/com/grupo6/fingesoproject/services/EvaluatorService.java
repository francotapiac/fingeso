package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Evaluator;
import com.grupo6.fingesoproject.repositories.EvaluatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evaluator")
public class EvaluatorService {
    @Autowired
    private EvaluatorRepository evaluatorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Evaluator> getAllEvaluator(){
        return evaluatorRepository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Evaluator getEvaluator(@PathVariable String id){
        return evaluatorRepository.findEvaluatorById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Evaluator> deleteEvaluator(@PathVariable String id){
        Evaluator evaluator = evaluatorRepository.findEvaluatorById(id);
        if(evaluator == null){
            return new ResponseEntity<Evaluator>(evaluator, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Evaluator>(evaluator, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Evaluator createEvaluator(@RequestBody Evaluator evaluator){
        return evaluatorRepository.save(evaluator);
    }
}
