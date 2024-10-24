package com.pjs.service.impl;

import com.pjs.datastore.ContestantStore;
import com.pjs.datastore.QuestionLibrary;
import com.pjs.io.output.ConsoleOutputPrinter;
import com.pjs.io.output.OutputPrinter;
import com.pjs.model.Problem;
import com.pjs.service.ProblemService;
import com.pjs.strategy.FilterStrategy;
import com.pjs.strategy.SortingStrategy;
import java.util.List;

public class ProblemServiceImpl implements ProblemService {

    private final OutputPrinter outputPrinter;
    private final QuestionLibrary questionLibrary;

    public ProblemServiceImpl() {
        this.outputPrinter = new ConsoleOutputPrinter();
        this.questionLibrary = new QuestionLibrary();
    }

    @Override
    public void addProblem(Problem problem) {
        outputPrinter.printMsg("===== Saving problem with name: " + problem.getName() + " ==========");
        questionLibrary.saveProblem(problem);
        outputPrinter.printMsg("===== Saved problem with name: " + problem.getName() + " ==========");
    }

    @Override
    public Problem getProblem(String problemId) {
        return questionLibrary.getProblem(problemId);
    }

    @Override
    public List<Problem> fetchProblems(FilterStrategy filterStrategy, SortingStrategy sortingStrategy) {
        List<Problem> problems = questionLibrary.getProblems();
        problems = filterStrategy.filter(problems);
        sortingStrategy.sort(problems);
        return problems;
    }
}
