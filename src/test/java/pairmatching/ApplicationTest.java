package pairmatching;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertShuffleTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @Disabled
    void 짝수_인원_페어_매칭() {
        assertShuffleTest(
            () -> {
                run("1", "백엔드, 레벨1, 자동차경주", "Q");
                assertThat(output()).contains("태웅 : 백호", "치수 : 태섭");
            },
            Arrays.asList("태웅", "백호", "치수", "태섭")
        );
    }

    @Test
    @Disabled
    void 없는_미션에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("1", "백엔드, 레벨1, 오징어게임");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
