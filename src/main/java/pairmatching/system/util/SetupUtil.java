package pairmatching.system.util;

import pairmatching.system.CrewsMaker;
import pairmatching.system.DependencyContainer;
import pairmatching.system.MissionMaker;
import pairmatching.system.holder.CrewsHolder;
import pairmatching.system.holder.MissionHolder;

import java.util.List;

public class SetupUtil {

    public static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";
    public static final String BACKEND_CREW_MD_PATH = "src/main/resources/backend-crew.md";

    private final CrewsMaker crewsMaker;
    private final MissionMaker missionMaker;

    public SetupUtil(CrewsMaker crewsMaker, MissionMaker missionMaker) {
        this.crewsMaker = crewsMaker;
        this.missionMaker = missionMaker;
    }

    public void setup() {
        setCrews();
        setMissions();
    }

    private static void setMissions() {
        MissionMaker missionMaker = new MissionMaker();
        MissionHolder.set(missionMaker.makeMissions());
    }

    private static void setCrews() {
        CrewsMaker crewMaker = DependencyContainer.getCrewMaker();
        CrewsHolder.set(
                getBackEndCrews(crewMaker),
                getFrontEndCrews(crewMaker)
        );
    }

    private static List<String> getFrontEndCrews(CrewsMaker crewsMaker) {
        return crewsMaker.readCrewsFromFile(FRONTEND_CREW_PATH);
    }

    private static List<String> getBackEndCrews(CrewsMaker crewsMaker) {
        return crewsMaker.readCrewsFromFile(BACKEND_CREW_MD_PATH);
    }
}
