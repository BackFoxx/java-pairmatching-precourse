package pairmatching.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewRepository {
    public final List<String> backEndCrews = new ArrayList<>();
    public final List<String> frontEndCrews = new ArrayList<>();

    public void saveAll(List<String> backEndCrews, List<String> frontEndCrews) {
        this.backEndCrews.addAll(backEndCrews);
        this.frontEndCrews.addAll(frontEndCrews);
    }

    public List<String> findAllBackEndCrews() {
        return Collections.unmodifiableList(backEndCrews);
    }

    public List<String> findAllFrontEndCrews() {
        return Collections.unmodifiableList(frontEndCrews);
    }
}
