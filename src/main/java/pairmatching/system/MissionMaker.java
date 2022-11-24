package pairmatching.system;

import pairmatching.vo.Level;
import pairmatching.vo.Mission;

import java.util.ArrayList;
import java.util.List;

public class MissionMaker {
    public List<Mission> makeMissions() {
        List<Mission> missions = new ArrayList<>();
        addLevelOne(missions);
        addLevelTwo(missions);
        addLevelFour(missions);

        return missions;
    }

    private static void addLevelFour(List<Mission> missions) {
        missions.add(new Mission(Level.LEVEL4, "성능개선"));
        missions.add(new Mission(Level.LEVEL4, "배포"));
    }

    private static void addLevelTwo(List<Mission> missions) {
        missions.add(new Mission(Level.LEVEL2, "장바구니"));
        missions.add(new Mission(Level.LEVEL2, "결제"));
        missions.add(new Mission(Level.LEVEL2, "지하철노선도"));
    }

    private static void addLevelOne(List<Mission> missions) {
        missions.add(new Mission(Level.LEVEL1, "자동차경주"));
        missions.add(new Mission(Level.LEVEL1, "로또"));
        missions.add(new Mission(Level.LEVEL1, "숫자야구게임"));
    }
}
