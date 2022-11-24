package pairmatching.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    private static List<String> getNames() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.toList());
    }

    public static Course getByName(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> name.equals(course.getName()))
                .findAny()
                .orElseThrow(IllegalStateException::new);
    }

    public static boolean isCourseNameValid(String name) {
        List<String> names = getNames();
        return names.contains(name);
    }
}
