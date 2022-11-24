package pairmatching.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("기능 선택을 유도하는 메시지를 출력한다.")
    void thenPrintsTodoSelectMessage() {
        //when
        outputView.printSelectTodoMessage();

        //then
        assertThat(outputStreamCaptor.toString())
                .isEqualToIgnoringNewLines("기능을 선택하세요.\n" +
                        "1. 페어 매칭\n" +
                        "2. 페어 조회\n" +
                        "3. 페어 초기화\n" +
                        "Q. 종료");
    }
}