import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bossmonster.Domain.Boss;
import bossmonster.Domain.Game;
import bossmonster.Domain.Player;
import bossmonster.Exception.GlobalExceptionHandler;
import bossmonster.Service.GameService;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {
    @Test
    @DisplayName("마법 공격 또는 물리 공격을 입력받아 공격 타입을 반환한다.")
    void getAttackTypeTest() {
        // given
        Scanner scanner = mock(Scanner.class);
        Boss boss = new Boss(100, 100);
        Player player = new Player(100, 100, "test");
        Game game = new Game(boss, player);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        GameService gameService = new GameService(scanner, exceptionHandler, game);
        when(scanner.nextInt()).thenReturn(1);

        // when
        int attackType = gameService.getAttackType();

        // then
        assertThat(attackType).isEqualTo(1);
    }

    @Test
    @DisplayName("마법 공격 또는 물리 공격을 입력받아 공격 타입을 반환한다. - 1 또는 2가 아닌 경우")
    void getAttackTypeTest2() {
        // given
        Scanner scanner = mock(Scanner.class);
        Boss boss = new Boss(100, 100);
        Player player = new Player(100, 100, "test");
        Game game = new Game(boss, player);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        GameService gameService = new GameService(scanner, exceptionHandler, game);
        when(scanner.nextInt()).thenReturn(3);
        when(exceptionHandler.handleIllegalAttackTypeException(any(IllegalArgumentException.class), eq(gameService))).thenReturn(1);

        // when
        int attackType = gameService.getAttackType();

        // then
        assertThat(attackType).isEqualTo(1);
    }
}
