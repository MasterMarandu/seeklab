package com.seek.springjwt;


import com.seek.springjwt.domain.Candidate;
import com.seek.springjwt.infrastructure.repository.CandidateRepository;
import com.seek.springjwt.service.impl.CandidateServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CandidateServiceTest {

    @Mock
    private CandidateRepository repository;

    @InjectMocks
    private CandidateServiceImpl service;


    @Test
    public void testGetAllCandidates() {
         List<Candidate> candidates = List.of(new Candidate());
         when(repository.findAll()).thenReturn(candidates);
        List<Candidate> result = service.getAllCandidates();
        assertThat(result.size()).isEqualTo(1);
    }
}
