package pairmatching.view;

import pairmatching.repository.MissionRepository;
import pairmatching.vo.Course;
import pairmatching.vo.Level;
import pairmatching.vo.Mission;
import pairmatching.vo.Todo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OutputView {

    public static final String ASKING_TO_SELECT_TODO_MESSAGE = "기능을 선택하세요.%n";
    public static final String SELECT_TODO_MESSAGE_FORMAT = "%s. %s%n";
    public static final String LINE_SEPARATOR = "#############################################%n";
    public static final String ASKING_TO_SELECT_WHAT_TO_MATCH_MESSAGE = "과정, 레벨, 미션을 선택하세요.%n";
    public static final String SELECT_WHAT_TO_MATCH_EXAMPLE_MESSAGE = "ex) 백엔드, 레벨1, 자동차경주%n";

    public void printSelectTodoMessage() {
        System.out.printf(ASKING_TO_SELECT_TODO_MESSAGE);
        for (Todo todo : Todo.values()) {
            System.out.printf(SELECT_TODO_MESSAGE_FORMAT, todo.getCommand(), todo.getDescription());
        }
    }

    public void printSelectWhatToMatchMessage(MissionRepository missionRepository) {
        System.out.printf(LINE_SEPARATOR);
        printCourseMessage();
        printMissions(missionRepository);
        System.out.printf(LINE_SEPARATOR);
        System.out.printf(ASKING_TO_SELECT_WHAT_TO_MATCH_MESSAGE);
        System.out.printf(SELECT_WHAT_TO_MATCH_EXAMPLE_MESSAGE);
    }

    private void printMissions(MissionRepository missionRepository) {
        System.out.printf("미션:%n");
        for (Level level : Level.values()) {
            System.out.printf("  - %s: ", level.getName());
            printMissionsHavingLevel(level, missionRepository);
        }
    }

    private void printMissionsHavingLevel(Level level, MissionRepository missionRepository) {
        List<Mission> missions = missionRepository.findByLevel(level);
        Iterator<Mission> iterator = missions.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            addSeparator(iterator);
        }
        System.out.println();
    }

    private void printCourseMessage() {
        System.out.print("과정: ");
        Iterator<Course> courses = Arrays.stream(Course.values()).iterator();
        while (courses.hasNext()) {
            System.out.print(courses.next().getName());
            addSeparator(courses);
        }
        System.out.println();
    }

    private static void addSeparator(Iterator<?> courses) {
        if (courses.hasNext()) {
            System.out.print(" | ");
        }
    }
}
