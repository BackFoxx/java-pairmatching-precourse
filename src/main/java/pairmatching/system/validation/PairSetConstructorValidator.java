package pairmatching.system.validation;

import pairmatching.vo.enums.Level;
import pairmatching.vo.Mission;

public class PairSetConstructorValidator {

    public static final String MISSION_NOT_THAT_LEVEL_MESSAGE = "입력한 미션이 입력한 레벨 안에 없습니다.";

    public static void validate(Level level, Mission mission) {
        isValidMissionLevel(level, mission);
    }

    private static void isValidMissionLevel(Level level, Mission mission) {
        if (!mission.isLevel(level)) {
            throw new IllegalArgumentException(MISSION_NOT_THAT_LEVEL_MESSAGE);
        }
    }
}
