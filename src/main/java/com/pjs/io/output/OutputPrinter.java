package com.pjs.io.output;

import com.pjs.model.Problem;
import java.util.List;

public interface OutputPrinter {

    void printMsg(String msg);

    void printProblems(List<Problem> problemList);

}
