package pairmatching.service;

import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import pairmatching.vo.Course;
import pairmatching.vo.Crew;
import pairmatching.vo.Pair;
import pairmatching.vo.PairSet;

import java.util.ArrayList;
import java.util.List;

public class PairService {
    private final PairRepository pairRepository;
    private final CrewRepository crewRepository;

    public PairService(PairRepository pairRepository, CrewRepository crewRepository) {
        this.pairRepository = pairRepository;
        this.crewRepository = crewRepository;
    }

    public void matchPair(PairSet pairSet) {
        crewRepository.shuffleCrews();
        List<Pair> pairs = new ArrayList<>();
        if (pairSet.getCourse() == Course.BACKEND) {
            makePairOfBackEndCrews(pairSet, pairs);
        }
        if (pairSet.getCourse() == Course.FRONTEND) {
            makePairOfFrontEndCrews(pairSet, pairs);
        }
    }

    private void makePairOfFrontEndCrews(PairSet pairSet, List<Pair> pairs) {
        makePair(crewRepository.findAllFrontEndCrews(), pairs);
        pairRepository.saveAt(pairSet, pairs);
    }

    private void makePairOfBackEndCrews(PairSet pairSet, List<Pair> pairs) {
        makePair(crewRepository.findAllBackEndCrews(), pairs);
        pairRepository.saveAt(pairSet, pairs);
    }

    private static void makePair(List<Crew> crews, List<Pair> pairs) {
        while (2 <= crews.size()) {
            List<Crew> tmpPairs = new ArrayList<>();
            tmpPairs.add(crews.remove(0));
            tmpPairs.add(crews.remove(0));
            if (crews.size() == 1) {
                tmpPairs.add(crews.remove(0));
            }
            pairs.add(new Pair(tmpPairs));
        }
    }
}
