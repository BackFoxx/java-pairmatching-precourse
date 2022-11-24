package pairmatching.system.validation;

import pairmatching.system.holder.MissionHolder;
import pairmatching.vo.Course;
import pairmatching.vo.Level;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputToPairSetValidator {

    public static final String INVALID_VALUE_SPLITTED_BY_COMMA = "쉼표로 구분된 세 값이 입력되지 않았습니다.";
    public static final String INVALID_COURSE_NAME_MESSAGE = "올바른 과정 이름이 아닙니다.";
    public static final String INVALID_LEVEL_NAME_MESSAGE = "올바른 레벨 이름이 아닙니다.";
    public static final String INVALID_MISSION_NAME_MESSAGE = "올바른 미션 이름이 아닙니다.";

    public static void validate(String target) {
        try {
            List<String> commands = Arrays.stream(target.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            isValidCourseName(commands.get(0));
            isValidLevelName(commands.get(1));
            isValidMissionName(commands.get(2));
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_VALUE_SPLITTED_BY_COMMA);
        }
    }

    private static void isValidCourseName(String courseName) {
        if (!Course.isCourseNameValid(courseName)) {
            throw new IllegalArgumentException(INVALID_COURSE_NAME_MESSAGE);
        }
    }

    private static void isValidLevelName(String levelName) {
        if (!Level.isValidLevelName(levelName)) {
            throw new IllegalArgumentException(INVALID_LEVEL_NAME_MESSAGE);
        }
    }

    private static void isValidMissionName(String missionName) {
        if (!MissionHolder.isValidMissionName(missionName)) {
            throw new IllegalArgumentException(INVALID_MISSION_NAME_MESSAGE);
        }
    }
}
