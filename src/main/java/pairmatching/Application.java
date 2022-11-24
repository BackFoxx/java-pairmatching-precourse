package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.system.DependencyContainer;
import pairmatching.system.util.SetupUtil;

public class Application {
    public static void main(String[] args) {
        SetupUtil setupUtil = DependencyContainer.getSetupUtil();
        setupUtil.setup();

        PairController pairController = DependencyContainer.getPairController();
        pairController.run();
    }
}
