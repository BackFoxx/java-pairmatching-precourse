package pairmatching.system.validation;

import pairmatching.vo.enums.ReMatchingCommand;

public class InputToReMatchingCommandValidator {
    public static final String INVALID_REMATCHING_COMMAND_MESSAGE = "다시 매칭할 지 여부는 네 또는 아니오만 입력할 수 있습니다.";

    public static void validate(String input) {
        isCommandYesOrNo(input);
    }

    private static void isCommandYesOrNo(String input) {
        if (!input.equals(ReMatchingCommand.YES.getCommand()) && !input.equals(ReMatchingCommand.NO.getCommand())) {
            throw new IllegalArgumentException(INVALID_REMATCHING_COMMAND_MESSAGE);
        }
    }
}
