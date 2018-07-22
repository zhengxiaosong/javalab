package cn.evilmoon.Labs;

import cn.evilmoon.Experiment;

public class Demo implements Experiment {
    @Override
    public void execute() {
        System.out.println("Hello world!");
    }
}
