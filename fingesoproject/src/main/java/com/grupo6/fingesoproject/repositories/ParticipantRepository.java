package com.grupo6.fingesoproject.repositories;

import com.grupo6.fingesoproject.models.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<Participant, Long> {
    public Participant findParticipantById(String id);
}
