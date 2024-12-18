package com.seek.springjwt.service.impl;


import com.seek.springjwt.domain.Candidate;
import com.seek.springjwt.domain.service.CandidateService;
import com.seek.springjwt.infrastructure.repository.CandidateRepository;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    public CandidateServiceImpl(CandidateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    @Override
    public Candidate getCandidateById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public void deleteCandidate(Long id) {
        repository.deleteById(id);
    }
}