package com.grupo6.fingesoproject.services;

import com.grupo6.fingesoproject.repositories.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/challenge")
public class ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;
}
