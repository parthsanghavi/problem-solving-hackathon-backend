package com.pjs.service;

import com.pjs.model.Problem;
import com.pjs.strategy.FilterStrategy;
import com.pjs.strategy.SortingStrategy;
import java.util.List;

public interface ProblemService {

    void addProblem(Problem problem);
    Problem getProblem(String problemId);
    List<Problem> fetchProblems(FilterStrategy filterStrategy, SortingStrategy sortingStrategy);

}
