package pairmatching.system;

import pairmatching.controller.PairController;
import pairmatching.system.util.SetupUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class DependencyContainer {
    public static SetupUtil getSetupUtil() {
        return new SetupUtil(getCrewMaker(), getMissionMaker());
    }

    public static CrewsMaker getCrewMaker() {
        return new CrewsMaker();
    }

    public static MissionMaker getMissionMaker() {
        return new MissionMaker();
    }

    public static PairController getPairController() {
        return new PairController(getInputView(), getOutputView());
    }

    public static InputView getInputView() {
        return new InputView();
    }

    public static OutputView getOutputView() {
        return new OutputView();
    }
}
