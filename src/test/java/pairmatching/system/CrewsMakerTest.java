package pairmatching.system;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CrewsMakerTest {
    @Test
    @DisplayName("주어진 파일을 한 줄씩 읽어 배열에 저장한다.")
    void givenFile_thenReturnsCrews() {
        //given
        CrewsMaker crewsMaker = new CrewsMaker();
        String path = "src/main/resources/backend-crew.md";
        //when
        List<String> crews = crewsMaker.readCrewsFromFile(path);
        //then
        assertThat(crews).hasSize(20);
    }
}