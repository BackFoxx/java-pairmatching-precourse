package pairmatching;

import pairmatching.system.DependencyContainer;
import pairmatching.system.util.SetupUtil;
import pairmatching.view.InputView;
import pairmatching.vo.Todo;

public class Application {
    public static void main(String[] args) {
        SetupUtil setupUtil = DependencyContainer.getSetupUtil();
        setupUtil.setup();

        InputView inputView = new InputView();
        Todo todo = inputView.getTodoCommand();
    }
}
