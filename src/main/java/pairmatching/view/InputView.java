package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.system.validation.InputToTodoValidator;
import pairmatching.vo.Todo;

public class InputView {
    public Todo getTodoCommand() {
        String input = readInput();
        InputToTodoValidator.validate(input);
        return Todo.getByValue(input);
    }

    protected String readInput() {
        return Console.readLine();
    }
}
