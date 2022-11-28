package pairmatching.controller;

import pairmatching.repository.MissionRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.vo.PairSet;
import pairmatching.vo.Todo;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;
    public final MissionRepository missionRepository;

    public PairController(InputView inputView, OutputView outputView, MissionRepository missionRepository) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.missionRepository = missionRepository;
    }

    public void run() {
        outputView.printSelectTodoMessage();
        Todo todo = inputView.getTodoCommand();

        if (todo == Todo.MATCHING) {
            doMatching();
        }
    }

    private void doMatching() {
        outputView.printSelectWhatToMatchMessage(missionRepository);
        PairSet pairSet = inputView.getPairSet(missionRepository);
    }
}
