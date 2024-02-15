import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bossmonster.Controller.GameController;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameControllerTest {
    @Test
    @DisplayName("물리공격, 마법공격 중 하나를 선택한다.")
    void SelectAttackTypeTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        GameController gameController = new GameController(scanner);

        // When
        when(scanner.nextInt()).thenReturn(1);
        int result = gameController.getAttackType();

        // Then
        assertThat(result).isEqualTo(1);

        // When
        when(scanner.nextInt()).thenReturn(2);
        result = gameController.getAttackType();

        // Then
        assertThat(result).isEqualTo(2);
    }
}
