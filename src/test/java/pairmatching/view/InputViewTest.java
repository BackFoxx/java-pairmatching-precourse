package pairmatching.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.mock.MockInputView;
import pairmatching.vo.Todo;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("사용자로부터 기능 선택을 받을 수 있다.")
    void givenInput_thenReturnsTodo() {
        //given
        InputView inputView = new MockInputView(Arrays.asList("3"));
        //when
        Todo todo = inputView.getTodoCommand();
        //then
        assertThat(todo).isEqualTo(Todo.RESET);
    }

    @Test
    @DisplayName("- 잘못된 값 입력시 예외를 발생한다.")
    void givenInvalidInput_thenException() {
        //given
        InputView inputView = new MockInputView(Arrays.asList("R"));
        //when
        assertThatThrownBy(inputView::getTodoCommand)
                .isInstanceOf(IllegalArgumentException.class);
    }
}