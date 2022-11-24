package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.system.holder.MissionHolder;
import pairmatching.system.validation.InputToPairSetValidator;
import pairmatching.system.validation.InputToTodoValidator;
import pairmatching.vo.Course;
import pairmatching.vo.Level;
import pairmatching.vo.PairSet;
import pairmatching.vo.Todo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public Todo getTodoCommand() {
        String input = readInput();
        InputToTodoValidator.validate(input);
        return Todo.getByValue(input);
    }

    public PairSet getPairSet() {
        String input = readInput();
        InputToPairSetValidator.validate(input);
        return convertInputToPairSet(input);
    }

    private PairSet convertInputToPairSet(String input) {
        List<String> commands = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return new PairSet(
                Course.getByName(commands.get(0)),
                Level.getByName(commands.get(1)),
                MissionHolder.getByName(commands.get(2))
        );
    }

    protected String readInput() {
        return Console.readLine();
    }
}
