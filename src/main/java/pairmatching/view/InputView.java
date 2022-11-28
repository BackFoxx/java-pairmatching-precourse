package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.repository.MissionRepository;
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

    public PairSet getPairSet(MissionRepository missionRepository) {
        String input = readInput();
        InputToPairSetValidator.validate(input, missionRepository);
        return convertInputToPairSet(input, missionRepository);
    }

    private PairSet convertInputToPairSet(String input, MissionRepository missionRepository) {
        List<String> commands = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return new PairSet(
                Course.getByName(commands.get(0)),
                Level.getByName(commands.get(1)),
                missionRepository.getByName(commands.get(2))
        );
    }

    protected String readInput() {
        return Console.readLine();
    }
}
