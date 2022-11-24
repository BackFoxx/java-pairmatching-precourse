package pairmatching.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.system.DependencyContainer;
import pairmatching.system.util.SetupUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView();

    @BeforeEach
    public void setUp() {
        SetupUtil setupUtil = DependencyContainer.getSetupUtil();
        setupUtil.setup();

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

    @Test
    @DisplayName("과정, 레벨, 미션을 선택하도록 유도하는 메시지를 출력한다.")
    void thenPrintsWhatToMatchMessage() {
        //given
        outputView.printSelectWhatToMatchMessage();

        //then
        assertThat(outputStreamCaptor.toString())
                .contains(
                        "#############################################\n",
                        "과정: 백엔드 | 프론트엔드\n",
                        "미션:\n",
                        "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n",
                        "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n",
                        "  - 레벨3: \n",
                        "  - 레벨4: 성능개선 | 배포\n",
                        "  - 레벨5: \n",
                        "############################################\n",
                        "과정, 레벨, 미션을 선택하세요.\n",
                        "ex) 백엔드, 레벨1, 자동차경주\n");
    }
}