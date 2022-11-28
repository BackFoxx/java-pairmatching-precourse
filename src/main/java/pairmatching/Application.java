package pairmatching;

import pairmatching.controller.PairController;
import pairmatching.system.DependencyContainer;
import pairmatching.system.util.SetupUtil;

public class Application {
    public static void main(String[] args) {
        DependencyContainer dependencyContainer = new DependencyContainer();
        dependencyContainer.getSetupUtil().setup();

        PairController pairController = dependencyContainer.getPairController();
        pairController.run();
    }
}
