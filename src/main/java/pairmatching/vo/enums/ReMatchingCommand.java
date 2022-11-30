package pairmatching.vo.enums;

import java.util.Arrays;

public enum ReMatchingCommand {
    YES("네"),
    NO("아니오");

    private final String command;

    ReMatchingCommand(String command) {
        this.command = command;
    }

    public static ReMatchingCommand getByValue(String input) {
        return Arrays.stream(ReMatchingCommand.values())
                .filter(reMatchingCommand -> reMatchingCommand.command.equals(input))
                .findAny()
                .get();
    }

    public String getCommand() {
        return command;
    }

    public boolean isRematching() {
        return this == ReMatchingCommand.YES;
    }
}
