package com.pjs.strategy;

import com.pjs.model.Contestant;
import com.pjs.model.Problem;
import com.pjs.service.ContestantService;
import java.util.List;
import java.util.Map;

public class ProblemScoreBasedWinnerStrategy implements WinningStrategy {

    private final ContestantService contestantService;

    public ProblemScoreBasedWinnerStrategy(ContestantService contestantService) {
        this.contestantService = contestantService;
    }

    @Override
    public Contestant getLeader() {
        Contestant winner = null;
        int maxScore = 0;
        List<Contestant> allContestants = contestantService.getAllContestants();
        for (Contestant contestant : allContestants) {
            int totalScore = 0;
            for (Problem problemSolved : contestantService.fetchSolvedProblems(contestant.getId())) {
                totalScore += problemSolved.getScore();
            }
            if (totalScore > maxScore) {
                winner = contestant;
            }
            maxScore = Math.max(maxScore, totalScore);
        }
        return winner;
    }
}
