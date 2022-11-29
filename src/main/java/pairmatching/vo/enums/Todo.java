package pairmatching.vo.enums;

public enum Todo {
    MATCHING("1", "페어 매칭"),
    FIND("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    public static final String INVALID_INPUT_VALUE_MESSAGE = "각 기능을 의미하는 커멘드(1, 2, 3, Q)만 입력하실 수 있습니다.";
    private final String command;
    private final String description;

    Todo(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static Todo getByValue(String input) {
        for (Todo todo : values()) {
            if (input.equals(todo.getCommand())) {
                return todo;
            }
        }

        throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
    }

    public String getDescription() {
        return description;
    }

    public String getCommand() {
        return command;
    }
}
