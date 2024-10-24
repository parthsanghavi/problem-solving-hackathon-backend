package com.pjs.service.impl;

import com.pjs.datastore.ContestantStore;
import com.pjs.io.output.ConsoleOutputPrinter;
import com.pjs.io.output.OutputPrinter;
import com.pjs.model.Contestant;
import com.pjs.model.Problem;
import com.pjs.service.ContestantService;
import java.util.List;

public class ContestantServiceImpl implements ContestantService  {

    private final ContestantStore contestantStore;
    private final OutputPrinter outputPrinter;

    public ContestantServiceImpl() {
        this.outputPrinter = new ConsoleOutputPrinter();
        this.contestantStore = new ContestantStore();
    }

    @Override
    public void registerContestant(Contestant contestant) {
        outputPrinter.printMsg("===== Registering contestant with name: " + contestant.getName() + " ==========");
        contestantStore.saveContestant(contestant);
        outputPrinter.printMsg("===== Successfully registered contestant with name: " + contestant.getName() + " ==========");
    }

    @Override
    public List<Contestant> getAllContestants() {
        return contestantStore.getAllContestants();
    }

    @Override
    public Contestant getContestant(String contestantId) {
        return contestantStore.getContestant(contestantId);
    }

    @Override
    public void solveProblem(Contestant contestant, Problem problem) {
        outputPrinter.printMsg("===== Contestant with name: " + contestant.getName() + " solved problem with name: " + problem.getName() +  " ==========");
        contestantStore.saveProblemSolved(contestant.getId(), problem);
    }

    @Override
    public List<Problem> fetchSolvedProblems(String contestantId) {
        return contestantStore.getProblemSolvedByContestantId(contestantId);
    }
}
