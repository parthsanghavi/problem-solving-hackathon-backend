package com.pjs;

import com.pjs.enums.Department;
import com.pjs.enums.ProblemDifficultyLevel;
import com.pjs.enums.SortOrder;
import com.pjs.io.output.ConsoleOutputPrinter;
import com.pjs.io.output.OutputPrinter;
import com.pjs.model.Contestant;
import com.pjs.model.Problem;
import com.pjs.model.builder.ContestantBuilder;
import com.pjs.model.builder.ProblemBuilder;
import com.pjs.service.ContestantService;
import com.pjs.service.ProblemService;
import com.pjs.service.impl.ContestantServiceImpl;
import com.pjs.service.impl.ProblemServiceImpl;
import com.pjs.strategy.FilterByDifficultyLevelStrategy;
import com.pjs.strategy.FilterStrategy;
import com.pjs.strategy.ProblemScoreBasedWinnerStrategy;
import com.pjs.strategy.SortByProblemScoreStrategy;
import com.pjs.strategy.SortingStrategy;
import com.pjs.strategy.WinningStrategy;
import java.util.List;

public class ProblemSolvingHackathonDriver {

    private final OutputPrinter outputPrinter;
    private final ContestantService contestantService;
    private final ProblemService problemService;

    public ProblemSolvingHackathonDriver() {
        this.outputPrinter = new ConsoleOutputPrinter();
        this.contestantService = new ContestantServiceImpl();
        this.problemService = new ProblemServiceImpl();
    }

    public void driveHackathon() {
        outputPrinter.printMsg("Starting the hackathon !!!");
        //add contestants
        outputPrinter.printMsg("Registering contestants !!!");
        addContestants();
        //add problems
        outputPrinter.printMsg("Adding problems !!!");
        addProblems();
        //fetch saved problems
        outputPrinter.printMsg("Fetching problems !!!");
        FilterStrategy filterStrategy = new FilterByDifficultyLevelStrategy(ProblemDifficultyLevel.EASY);
        SortingStrategy sortingStrategy = new SortByProblemScoreStrategy(SortOrder.DESC);
        List<Problem> problemList = problemService.fetchProblems(filterStrategy, sortingStrategy);
        outputPrinter.printProblems(problemList);
        //contestant 1 solves problems
        outputPrinter.printMsg("Contestant1 is solving the problems");
        Contestant contestant1 = contestantService.getContestant("1");
        Problem problem1C1 = problemService.getProblem("1");
        Problem problem2C1 = problemService.getProblem("2");
        contestantService.solveProblem(contestant1, problem1C1);
        contestantService.solveProblem(contestant1, problem2C1);
        outputPrinter.printMsg("Contestant1 solved problems 1,2");
        //contestant 2 solves problems
        outputPrinter.printMsg("Contestant2 is solving the problems");
        Contestant contestant2 = contestantService.getContestant("2");
        Problem problem3C2 = problemService.getProblem("3");
        Problem problem4C2 = problemService.getProblem("4");
        contestantService.solveProblem(contestant2, problem3C2);
        contestantService.solveProblem(contestant2, problem4C2);
        outputPrinter.printMsg("Contestant2 solved problems 3,4");
        //fetching problems solved
        for (Contestant contestant : contestantService.getAllContestants()) {
            outputPrinter.printMsg("Problems solved by contestant: " + contestant.getName());
            List<Problem> problems = contestantService.fetchSolvedProblems(contestant.getId());
            outputPrinter.printProblems(problems);
        }
        //get the leader
        WinningStrategy winningStrategy = new ProblemScoreBasedWinnerStrategy(contestantService);
        Contestant winner = winningStrategy.getLeader();
        outputPrinter.printMsg("Winner is: " + winner.getName());
        outputPrinter.printMsg("Completed the hackathon !!!");
    }

    private void addContestants() {
        //add first contestant
        ContestantBuilder contestantBuilder1 = new ContestantBuilder();
        contestantBuilder1.setId("1")
              .setName("Contestant1")
              .setDepartmentName(Department.RESEARCH);
        contestantService.registerContestant(contestantBuilder1.build());

        //add second contestant
        ContestantBuilder contestantBuilder2 = new ContestantBuilder();
        contestantBuilder2.setId("2")
              .setName("Contestant2")
              .setDepartmentName(Department.DEVELOPMENT);
        contestantService.registerContestant(contestantBuilder2.build());

        //add third contestant
        ContestantBuilder contestantBuilder3 = new ContestantBuilder();
        contestantBuilder3.setId("3")
              .setName("Contestant3")
              .setDepartmentName(Department.DEVOPS);
        contestantService.registerContestant(contestantBuilder3.build());
    }

    private void addProblems() {
        //add first problem
        ProblemBuilder problemBuilder1 = new ProblemBuilder();
        problemBuilder1.setId("1")
              .setName("Buy Sell Stock")
              .setDescription("Stock purchase and sell with max profit")
              .setProblemDifficultyLevel(ProblemDifficultyLevel.EASY)
              .setScore(4)
              .setTags("Array")
              .setTags("PhonePe");
        problemService.addProblem(problemBuilder1.build());

        //add second problem
        ProblemBuilder problemBuilder2 = new ProblemBuilder();
        problemBuilder2.setId("2")
              .setName("K size maximum subset sum array")
              .setDescription("Find the subset of size k with max sum")
              .setProblemDifficultyLevel(ProblemDifficultyLevel.MEDIUM)
              .setScore(7)
              .setTags("Array")
              .setTags("GPay");
        problemService.addProblem(problemBuilder2.build());

        //add third problem
        ProblemBuilder problemBuilder3 = new ProblemBuilder();
        problemBuilder3.setId("3")
              .setName("0/1 Knapsack")
              .setDescription("Find the max profit in knapsack")
              .setProblemDifficultyLevel(ProblemDifficultyLevel.HARD)
              .setScore(10)
              .setTags("Dynamic-Programming")
              .setTags("PhonePe");
        problemService.addProblem(problemBuilder3.build());

        //add fourth problem
        ProblemBuilder problemBuilder4 = new ProblemBuilder();
        problemBuilder4.setId("4")
              .setName("Easy leetcode problem")
              .setDescription("Easy leetcode problem")
              .setProblemDifficultyLevel(ProblemDifficultyLevel.EASY)
              .setScore(2)
              .setTags("String")
              .setTags("PhonePe");
        problemService.addProblem(problemBuilder4.build());
    }
}
