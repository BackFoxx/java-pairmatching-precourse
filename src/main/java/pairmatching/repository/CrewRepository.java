package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.vo.Crew;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
    private final List<Crew> backEndCrews = new ArrayList<>();
    private final List<Crew> frontEndCrews = new ArrayList<>();

    public void saveAll(List<Crew> backEndCrews, List<Crew> frontEndCrews) {
        this.backEndCrews.addAll(backEndCrews);
        this.frontEndCrews.addAll(frontEndCrews);
    }

    public List<Crew> findAllBackEndCrews() {
        return new ArrayList<>(backEndCrews);
    }

    public List<Crew> findAllFrontEndCrews() {
        return new ArrayList<>(frontEndCrews);
    }

    public void shuffleCrews() {
        Randoms.shuffle(backEndCrews);
        Randoms.shuffle(frontEndCrews);
    }
}
