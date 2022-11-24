package pairmatching.view;

import pairmatching.vo.Todo;

public class OutputView {

    public static final String ASKING_TO_SELECT_TODO_MESSAGE = "기능을 선택하세요.%n";
    public static final String SELECT_TODO_MESSAGE_FORMAT = "%s. %s%n";

    public void printSelectTodoMessage() {
        System.out.printf(ASKING_TO_SELECT_TODO_MESSAGE);
        for (Todo todo : Todo.values()) {
            System.out.printf(SELECT_TODO_MESSAGE_FORMAT, todo.getCommand(), todo.getDescription());
        }
    }
}
