package com.pjs.strategy;

import com.pjs.model.Problem;
import java.util.List;

public interface FilterStrategy {

    List<Problem> filter(List<Problem> problems);
}
