package pairmatching.repository;

import pairmatching.vo.Level;
import pairmatching.vo.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MissionRepository {
    private final List<Mission> missions = new ArrayList<>();

    public void saveAll(List<Mission> missions) {
        this.missions.addAll(missions);
    }

    public List<Mission> findByLevel(Level level) {
        return missions
                .stream().filter(mission -> mission.isLevel(level))
                .collect(Collectors.toList());
    }

    public boolean isValidMissionName(String missionName) {
        List<String> names = missions
                .stream().map(Mission::getName)
                .collect(Collectors.toList());

        return names.contains(missionName);
    }

    public Mission getByName(String name) {
        return missions
                .stream().filter(mission -> name.equals(mission.getName()))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }
}
