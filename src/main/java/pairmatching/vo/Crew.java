package pairmatching.vo;

import java.util.ArrayList;
import java.util.List;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static List<Crew> from(List<String> crewNames, Course course) {
        List<Crew> crews = new ArrayList<>();
        for (String crewName : crewNames) {
            crews.add(new Crew(course, crewName));
        }
        return crews;
    }

    public String getName() {
        return name;
    }
}
