package com.pjs.io.output;

import com.pjs.model.Problem;
import java.util.List;

public class ConsoleOutputPrinter implements OutputPrinter {

    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printProblems(List<Problem> problemList) {
        for (Problem problem : problemList) {
            System.out.println("Problem is: " + problem.toString());
        }
    }
}
