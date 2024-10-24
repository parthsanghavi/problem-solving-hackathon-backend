package com.pjs.strategy;

import com.pjs.enums.ProblemDifficultyLevel;
import com.pjs.model.Problem;
import java.util.List;
import java.util.stream.Collectors;

public class FilterByDifficultyLevelStrategy implements FilterStrategy {

    private final ProblemDifficultyLevel problemDifficultyLevel;

    public FilterByDifficultyLevelStrategy(ProblemDifficultyLevel problemDifficultyLevel) {
        this.problemDifficultyLevel = problemDifficultyLevel;
    }

    @Override
    public List<Problem> filter(List<Problem> problems) {
        return problems.stream()
              .filter(problem -> problem.getProblemDifficultyLevel().equals(this.problemDifficultyLevel))
              .collect(Collectors.toList());
    }
}
