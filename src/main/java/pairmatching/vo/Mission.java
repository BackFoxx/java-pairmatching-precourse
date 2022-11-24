package pairmatching.vo;

public class Mission {
    private final Level level;
    private final String name;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public boolean isLevel(Level level) {
        return this.level.equals(level);
    }

    @Override
    public String toString() {
        return name;
    }
}
