import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bossmonster.Controller.BossController;
import bossmonster.Exception.ExceptionHandler;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

public class BossControllerTest {
    @Test
    @DisplayName("Boss의 HP를 입력받는다.")
    void BossHpInputTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        BossController bossController = new BossController(scanner);

        // When
        when(scanner.nextInt()).thenReturn(150);
        int result = bossController.getBossHp();

        // Then
        assertThat(result).isEqualTo(150);
    }
}