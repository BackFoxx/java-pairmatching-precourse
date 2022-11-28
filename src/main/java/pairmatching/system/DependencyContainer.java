package pairmatching.system;

import pairmatching.controller.PairController;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.system.util.SetupUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class DependencyContainer {
    private SetupUtil setupUtil = null;
    private CrewsMaker crewsMaker = null;
    private MissionMaker missionMaker = null;
    private PairController pairController;
    private InputView inputView = null;
    private OutputView outputView = null;
    private MissionRepository missionRepository = null;
    private CrewRepository crewRepository = null;

    public SetupUtil getSetupUtil() {
        if (setupUtil == null) {
            setupUtil = new SetupUtil(
                    getCrewMaker(), getMissionMaker(), getMissionRepository(), getCrewRepository()
            );
        }
        return setupUtil;
    }

    public CrewsMaker getCrewMaker() {
        if (crewsMaker == null) {
            crewsMaker = new CrewsMaker();
        }
        return crewsMaker;
    }

    public MissionMaker getMissionMaker() {
        if (missionMaker == null) {
            missionMaker = new MissionMaker();
        }
        return missionMaker;
    }

    public PairController getPairController() {
        if (pairController == null) {
            pairController = new PairController(getInputView(), getOutputView(), getMissionRepository());
        }
        return pairController;
    }

    public InputView getInputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView getOutputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public MissionRepository getMissionRepository() {
        if (missionRepository == null) {
            missionRepository = new MissionRepository();
        }
        return missionRepository;
    }

    public CrewRepository getCrewRepository() {
        if (crewRepository == null) {
            crewRepository = new CrewRepository();
        }
        return crewRepository;
    }
}
