package pairmatching.controller;

import pairmatching.inputview.InputView;
import pairmatching.outputview.OutputView;
import pairmatching.vo.FeatureCommand;

import java.util.Map;

public class SelectingFeatureController implements Controller {
    private final OutputView outputView;
    private final InputView<FeatureCommand> inputView;

    public SelectingFeatureController(OutputView outputView, InputView<FeatureCommand> inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    @Override
    public void process(Map<String, Object> model) {
        outputView.print(model);
        model.put("featureCommand", inputView.getInput());
    }
}