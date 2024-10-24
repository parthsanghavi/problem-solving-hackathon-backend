package com.pjs.service;

import com.pjs.model.Contestant;
import com.pjs.model.Problem;
import java.util.List;

public interface ContestantService {

    void registerContestant(Contestant contestant);
    List<Contestant> getAllContestants();
    Contestant getContestant(String contestantId);
    void solveProblem(Contestant contestant, Problem problem);
    List<Problem> fetchSolvedProblems(String contestantId);
}
