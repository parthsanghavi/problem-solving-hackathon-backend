package com.pjs.datastore;

import com.pjs.exception.InvalidInputException;
import com.pjs.model.Problem;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionLibrary {

    //map to store the problems in database
    private final Map<String, Problem> problemMap = new HashMap<>();      //problem-id -> problem

    public void saveProblem(Problem problem) {
        if (problemMap.containsKey(problem.getId())) {
            throw new InvalidInputException("Problem with same id already exists");
        }
        problemMap.put(problem.getId(), problem);
    }

    public Problem getProblem(String problemId) {
        return problemMap.get(problemId);
    }

    public List<Problem> getProblems() {
        List<Problem> problems = problemMap.values()
              .stream()
              .collect(Collectors.toList());
        return problems;
    }
}
