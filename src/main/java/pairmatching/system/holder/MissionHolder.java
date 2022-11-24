package pairmatching.system.holder;

import pairmatching.vo.Mission;

import java.util.List;

public class MissionHolder {
    public static ThreadLocal<List<Mission>> missions = new ThreadLocal<>();

    public static void set(List<Mission> missionsInput) {
        missions.set(missionsInput);
    }

    public static List<Mission> getMissions() {
        return missions.get();
    }
}
