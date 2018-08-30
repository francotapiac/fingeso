package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.models.Evaluation;
import com.grupo6.fingesoproject.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evaluation")
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Evaluation> getAllEvaluation(){
        return evaluationRepository.findAll();
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Evaluation getEvaluation(@PathVariable String id){
        return evaluationRepository.findEvaluationById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Evaluation> deleteEvaluation(@PathVariable String id){
        Evaluation evaluation = evaluationRepository.findEvaluationById(id);
        if(evaluation == null){
            return new ResponseEntity<Evaluation>(evaluation, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Evaluation>(evaluation, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Evaluation createEvaluation(@RequestBody Evaluation evaluation){
        return evaluationRepository.save(evaluation);
    }
}
