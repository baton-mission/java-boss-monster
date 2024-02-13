import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bossmonster.Controller.PlayerController;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerControllerTest {
    @Test
    @DisplayName("플레이어의 이름을 입력받는다.")
    void PlayerNameInputTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        PlayerController playerController = new PlayerController(scanner);

        // When
        when(scanner.nextLine()).thenReturn("플레이어1");
        String result = playerController.getPlayerName();

        // Then
        assertThat(result).isEqualTo("플레이어1");
    }

    @Test
    @DisplayName("플레이어의 HP와 MP를 입력받는다.")
    void PlayerHpMpInputTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        PlayerController playerController = new PlayerController(scanner);

        // When
        when(scanner.nextLine()).thenReturn("150,50");
        int[] result = playerController.getPlayerHpMp();

        // Then
        assertThat(result).containsExactly(150, 50);
    }
}
