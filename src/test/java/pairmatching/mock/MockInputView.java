package pairmatching.mock;

import pairmatching.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MockInputView extends InputView {
    private List<String> mockValues;

    public MockInputView(List<String> mockValues) {
        this.mockValues = new ArrayList<>(mockValues);
    }

    @Override
    protected String readInput() {
        return mockValues.remove(0);
    }
}
