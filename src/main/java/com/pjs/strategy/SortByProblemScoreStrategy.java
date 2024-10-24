package com.pjs.strategy;

import com.pjs.enums.SortOrder;
import com.pjs.model.Problem;
import java.util.Comparator;
import java.util.List;

public class SortByProblemScoreStrategy implements SortingStrategy {

    private final SortOrder sortOrder;

    public SortByProblemScoreStrategy(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public void sort(List<Problem> problems) {
        switch (sortOrder) {
            case ASC -> problems.sort(Comparator.comparing(Problem::getScore));
            case DESC -> problems.sort(Comparator.comparing(Problem::getScore).reversed());
        }
    }
}
