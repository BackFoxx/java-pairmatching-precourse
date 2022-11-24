package pairmatching.system.validation;

import pairmatching.vo.Todo;

public class InputToTodoValidator {
    public static void validate(String input) {
        isConsistedOfValidValue(input);
    }

    private static void isConsistedOfValidValue(String target) {
        if (!target.matches("^[123Q]{1}$")) {
            throw new IllegalArgumentException(Todo.INVALID_INPUT_VALUE_MESSAGE);
        }
    }
}
