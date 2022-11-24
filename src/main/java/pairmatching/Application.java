package pairmatching;

import pairmatching.system.CrewsMaker;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CrewsMaker crewsMaker = new CrewsMaker();
        List<String> backEndCrews = crewsMaker.readCrewsFromFile("src/main/resources/backend-crew.md");
        List<String> frontEndCrews = crewsMaker.readCrewsFromFile("src/main/resources/frontend-crew.md");


    }
}
