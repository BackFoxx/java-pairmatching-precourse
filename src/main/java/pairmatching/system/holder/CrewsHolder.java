package pairmatching.system.holder;

import java.util.Collections;
import java.util.List;

public class CrewsHolder {
    public static ThreadLocal<List<String>> backEndCrews = new ThreadLocal<>();
    public static ThreadLocal<List<String>> frontEndCrews = new ThreadLocal<>();

    public static void set(List<String> backEndCrewsInput, List<String> frontEndCrewsInput) {
        backEndCrews.set(backEndCrewsInput);
        frontEndCrews.set(frontEndCrewsInput);
    }

    public static List<String> getBackEndCrews() {
        return Collections.unmodifiableList(backEndCrews.get());
    }

    public static List<String> getFrontEndCrews() {
        return Collections.unmodifiableList(frontEndCrews.get());
    }
}
