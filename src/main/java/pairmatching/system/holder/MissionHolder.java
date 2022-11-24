package pairmatching.system.holder;

import pairmatching.vo.Level;
import pairmatching.vo.Mission;

import java.util.List;
import java.util.stream.Collectors;

public class MissionHolder {
    public static ThreadLocal<List<Mission>> missions = new ThreadLocal<>();

    public static void set(List<Mission> missionsInput) {
        missions.set(missionsInput);
    }

    public static List<Mission> getMissions() {
        return missions.get();
    }

    public static List<Mission> findByLevel(Level level) {
        return missions.get()
                .stream().filter(mission -> mission.isLevel(level))
                .collect(Collectors.toList());
    }

    public static boolean isValidMissionName(String missionName) {
        List<String> names = missions.get()
                .stream().map(mission -> mission.getName())
                .collect(Collectors.toList());

        return names.contains(missionName);
    }

    public static Mission getByName(String name) {
        return missions.get()
                .stream().filter(mission -> name.equals(mission.getName()))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }
}
