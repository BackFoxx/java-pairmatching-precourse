package pairmatching.system.util;

import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.system.CrewsMaker;
import pairmatching.system.MissionMaker;

import java.util.List;

public class SetupUtil {
    public static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";
    public static final String BACKEND_CREW_MD_PATH = "src/main/resources/backend-crew.md";

    private final CrewsMaker crewsMaker;
    private final MissionMaker missionMaker;
    private final MissionRepository missionRepository;
    private final CrewRepository crewsRepository;

    public SetupUtil(CrewsMaker crewsMaker,
                     MissionMaker missionMaker,
                     MissionRepository missionRepository,
                     CrewRepository crewsRepository) {
        this.crewsMaker = crewsMaker;
        this.missionMaker = missionMaker;
        this.missionRepository = missionRepository;
        this.crewsRepository = crewsRepository;
    }

    public void setup() {
        setCrews();
        setMissions();
    }

    private void setMissions() {
        missionRepository.saveAll(missionMaker.makeMissions());
    }

    private void setCrews() {
        crewsRepository.saveAll(
                getBackEndCrews(crewsMaker),
                getFrontEndCrews(crewsMaker)
        );
    }

    private List<String> getFrontEndCrews(CrewsMaker crewsMaker) {
        return crewsMaker.readCrewsFromFile(FRONTEND_CREW_PATH);
    }

    private List<String> getBackEndCrews(CrewsMaker crewsMaker) {
        return crewsMaker.readCrewsFromFile(BACKEND_CREW_MD_PATH);
    }
}
