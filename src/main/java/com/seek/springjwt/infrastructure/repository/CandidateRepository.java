package com.seek.springjwt.infrastructure.repository;


import com.seek.springjwt.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}