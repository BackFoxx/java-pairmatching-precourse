package pairmatching.system.util;

import pairmatching.system.CrewsMaker;
import pairmatching.system.MissionMaker;

public class SetupUtil {
    private final CrewsMaker crewsMaker;
    private final MissionMaker missionMaker;

    public SetupUtil(CrewsMaker crewsMaker, MissionMaker missionMaker) {
        this.crewsMaker = crewsMaker;
        this.missionMaker = missionMaker;
    }
}
