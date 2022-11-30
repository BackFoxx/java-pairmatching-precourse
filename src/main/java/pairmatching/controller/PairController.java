package pairmatching.controller;

import pairmatching.repository.MissionRepository;
import pairmatching.repository.PairRepository;
import pairmatching.service.PairService;
import pairmatching.system.exception.PairAlreadyExistingException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.vo.PairSet;
import pairmatching.vo.enums.Todo;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;
    public final MissionRepository missionRepository;
    public final PairRepository pairRepository;
    public final PairService pairService;

    public PairController(InputView inputView, OutputView outputView, MissionRepository missionRepository, PairRepository pairRepository, PairService pairService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.missionRepository = missionRepository;
        this.pairRepository = pairRepository;
        this.pairService = pairService;
    }

    public void run() {
        outputView.printSelectTodoMessage();
        Todo todo = inputView.getTodoCommand();

        if (todo == Todo.MATCHING) {
            doMatching();
        }
    }

    private void doMatching() {
        try {
            outputView.printSelectWhatToMatchMessage(missionRepository);
            makePairs();
        } catch (PairAlreadyExistingException e) {
            outputView.printPairAlreadyExistsMessage();
            if (inputView.getReMatchingCommand().isRematching()) {
                makePairs();
            }
        }
    }

    private void makePairs() {
        PairSet pairSet = getPairSet();
        pairService.matchPair(pairSet);
        printMatchingResult(pairSet);
    }

    private void printMatchingResult(PairSet pairSet) {
        outputView.printMatchingResultMessage(pairRepository.findByPairSet(pairSet));
    }

    private PairSet getPairSet() {
        return inputView.getPairSet(missionRepository);
    }
}
