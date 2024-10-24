package com.pjs.model.builder;

import com.pjs.enums.ProblemDifficultyLevel;
import com.pjs.model.Problem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProblemBuilder {

    private String id;
    private String name;
    private String description;
    private List<String> tags;
    private ProblemDifficultyLevel problemDifficultyLevel;
    private int score;

    public ProblemBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public ProblemBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProblemBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProblemBuilder setTags(String tag) {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        tags.add(tag);
        return this;
    }

    public ProblemBuilder setProblemDifficultyLevel(ProblemDifficultyLevel problemDifficultyLevel) {
        this.problemDifficultyLevel = problemDifficultyLevel;
        return this;
    }

    public ProblemBuilder setScore(int score) {
        this.score = score;
        return this;
    }

    public Problem build() {
        return new Problem(
              this.id,
              this.name,
              this.description,
              this.tags,
              this.problemDifficultyLevel,
              this.score
        );
    }

}
