package pairmatching.system;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewsMaker {
    public List<String> readCrewsFromFile(String path) {
        try {
            return getCrewsFromFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getCrewsFromFile(String path) throws IOException {
        FileReader fileReader = getFileReader(path);
        BufferedReader bufferedReader = getBufferedReader(fileReader);

        List<String> crews = getEachCrew(bufferedReader);
        bufferedReader.close();
        return crews;
    }

    private static BufferedReader getBufferedReader(FileReader fileReader) {
        return new BufferedReader(fileReader);
    }

    private static List<String> getEachCrew(BufferedReader bufferedReader) throws IOException {
        ArrayList<String> crews = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            crews.add(line);
        }

        return crews;
    }

    private static FileReader getFileReader(String path) throws FileNotFoundException {
        File file = new File(path);
        return new FileReader(file);
    }
}
