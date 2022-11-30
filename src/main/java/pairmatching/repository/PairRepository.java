package pairmatching.repository;

import pairmatching.system.exception.PairAlreadyExistingException;
import pairmatching.vo.Pair;
import pairmatching.vo.PairSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairRepository {
    private final Map<PairSet, List<Pair>> pairMatchResults = new HashMap<>();

    public void saveAt(PairSet pairSet, List<Pair> pairs) {
        if (pairMatchResults.get(pairSet) != null) {
            throw new PairAlreadyExistingException();
        }
        pairMatchResults.put(pairSet, pairs);
    }

    public List<Pair> findByPairSet(PairSet pairSet) {
        return new ArrayList<>(pairMatchResults.get(pairSet));
    }
}
