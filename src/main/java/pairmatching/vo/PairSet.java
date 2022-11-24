package pairmatching.vo;

import pairmatching.system.validation.PairSetConstructorValidator;

public class PairSet {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairSet(Course course, Level level, Mission mission) {
        PairSetConstructorValidator.validate(level, mission);
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
