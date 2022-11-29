package pairmatching.vo.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public String getName() {
        return name;
    }

    public static boolean isValidLevelName(String levelName) {
        List<String> names = Arrays.stream(Level.values())
                .map(Level::getName)
                .collect(Collectors.toList());

        return names.contains(levelName);
    }

    public static Level getByName(String name) {
        return Arrays.stream(Level.values())
                .filter(course -> name.equals(course.getName()))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }
}
