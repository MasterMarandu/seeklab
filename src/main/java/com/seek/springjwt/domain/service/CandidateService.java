package com.seek.springjwt.domain.service;

import com.seek.springjwt.domain.Candidate;
import java.util.List;

public interface CandidateService {
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(Long id);
    Candidate createCandidate(Candidate candidate);
    void deleteCandidate(Long id);
}