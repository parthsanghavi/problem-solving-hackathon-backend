package com.pjs.strategy;

import com.pjs.model.Contestant;

public interface WinningStrategy {

    Contestant getLeader();

}
