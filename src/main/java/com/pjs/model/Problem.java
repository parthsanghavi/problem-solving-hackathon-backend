package com.pjs.model;

import com.pjs.enums.ProblemDifficultyLevel;
import java.util.List;

public class Problem {

    private String id;
    private String name;
    private String description;
    private List<String> tags;
    private ProblemDifficultyLevel problemDifficultyLevel;
    private int score;

    public Problem(String id, String name, String description, List<String> tags, ProblemDifficultyLevel problemDifficultyLevel,
          int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.problemDifficultyLevel = problemDifficultyLevel;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public ProblemDifficultyLevel getProblemDifficultyLevel() {
        return problemDifficultyLevel;
    }

    public void setProblemDifficultyLevel(ProblemDifficultyLevel problemDifficultyLevel) {
        this.problemDifficultyLevel = problemDifficultyLevel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return "Problem{"
               + "Id: " + this.id + ","
               + "Name: " + this.name + ","
               + "Desc: " + this.description + ","
               + "Difficulty: " + this.problemDifficultyLevel.name() + ","
               + "Tags: " + this.tags.toString() + ","
               + "Score: " + this.score
               + "}";
    }
}
