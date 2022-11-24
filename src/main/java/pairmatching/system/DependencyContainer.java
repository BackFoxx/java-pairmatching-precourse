package pairmatching.system;

import pairmatching.system.util.SetupUtil;

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
}
