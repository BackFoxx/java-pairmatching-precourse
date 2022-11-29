package pairmatching.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.vo.enums.Level;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PairSetTest {
    @Test
    @DisplayName("입력한 레벨과 미션이 안 맞으면 예외가 발생한다.")
    void givenMissionNotThatLevel_thenException() {
        //given & when & then
        assertThatThrownBy(() -> new PairSet(
                Course.FRONTEND,
                Level.LEVEL4,
                new Mission(Level.LEVEL2, "테스트 미션")
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 레벨과 미션이 맞으면 객체를 정상적으로 만든다.")
    void givenInput_thenReturnsPairSet() {
        //given & when & then
        assertThatCode(() -> new PairSet(
                Course.FRONTEND,
                Level.LEVEL4,
                new Mission(Level.LEVEL4, "테스트 미션")
        )).doesNotThrowAnyException();
    }
}