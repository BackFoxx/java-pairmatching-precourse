package pairmatching.controller;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.vo.PairSet;
import pairmatching.vo.Todo;

public class PairController {
    private final InputView inputView;
    private final OutputView outputView;

    public PairController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printSelectTodoMessage();
        Todo todo = inputView.getTodoCommand();

        if (todo == Todo.MATCHING) {
            doMatching();
        }
    }

    private void doMatching() {
        outputView.printSelectWhatToMatchMessage();
        PairSet pairSet = inputView.getPairSet();
    }
}
