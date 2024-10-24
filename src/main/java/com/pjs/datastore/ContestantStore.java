package com.pjs.datastore;

import com.pjs.exception.InvalidInputException;
import com.pjs.model.Contestant;
import com.pjs.model.Problem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContestantStore {

    //map to store the contestants data
    private final Map<String, Contestant> contestantMap = new HashMap<>();                //contestant-id -> contestant

    //map to store the problems solved by contestant
    private final Map<String, List<Problem>> contestantProblemSolved = new HashMap<>();    //contestant-id -> problems

    public void saveContestant(Contestant contestant) {
        if (contestantMap.containsKey(contestant.getId())) {
            throw new InvalidInputException("Contestant with id already exists");
        }
        contestantMap.put(contestant.getId(), contestant);
    }

    public List<Contestant> getAllContestants() {
        return contestantMap.values().stream().collect(Collectors.toList());
    }

    public Contestant getContestant(String contestantId) {
        return contestantMap.get(contestantId);
    }

    public void saveProblemSolved(String contestantId, Problem problem) {
        if (!contestantMap.containsKey(contestantId)) {
            throw new InvalidInputException("Contestant does not exist");
        }
        if (!contestantProblemSolved.containsKey(contestantId)) {
            contestantProblemSolved.put(contestantId, new ArrayList<>());
        }
        contestantProblemSolved.get(contestantId).add(problem);
    }

    public List<Problem> getProblemSolvedByContestantId(String contestantId) {
        if (!contestantMap.containsKey(contestantId)) {
            throw new InvalidInputException("Contestant does not exist");
        }
        if (!contestantProblemSolved.containsKey(contestantId)) {
            contestantProblemSolved.put(contestantId, new ArrayList<>());
        }
        return contestantProblemSolved.get(contestantId);
    }
}
