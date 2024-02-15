import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import bossmonster.Domain.Boss;
import bossmonster.Domain.Player;
import bossmonster.Dto.AttackResult;
import bossmonster.Exception.GlobalExceptionHandler;
import bossmonster.Service.PlayerService;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerServiceTest {
    @Test
    @DisplayName("Player의 이름과 HP, MP를 입력받아 Player 객체를 반환한다.")
    void getPlayerTest() {
        // given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        PlayerService playerService = new PlayerService(scanner, exceptionHandler);
        when(scanner.nextLine()).thenReturn("test", "100,100");

        // when
        Player player = playerService.getPlayer();

        // then
        assertThat(player.getName()).isEqualTo("test");
        assertThat(player.getMaxHp()).isEqualTo(100);
        assertThat(player.getMaxMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("Player의 이름은 6자이고 HP, MP의 합이 200인 경우")
    void getPlayerTest2() {
        // given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        PlayerService playerService = new PlayerService(scanner, exceptionHandler);
        when(exceptionHandler.handleIllegalPlayerNameException(any(IllegalArgumentException.class), eq(playerService), eq(100), eq(100))).thenReturn(new Player(100, 100, "12345"));

        // when
        when(scanner.nextLine()).thenReturn("123456", "100,100", "12345");
        Player player = playerService.getPlayer();

        // then
        assertThat(player.getName()).isEqualTo("12345");
        assertThat(player.getMaxHp()).isEqualTo(100);
        assertThat(player.getMaxMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("Player의 이름은 5자이고 HP, MP의 합이 200이 아닌 경우")
    void getPlayerTest3() {
        // given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        PlayerService playerService = new PlayerService(scanner, exceptionHandler);
        when(exceptionHandler.handleIllegalPlayerHpMpException(any(IllegalArgumentException.class), eq(playerService), eq("12345"))).thenReturn(new Player(20, 180, "12345"));
        // when
        when(scanner.nextLine()).thenReturn("12345", "100,1990", "20,180");
        Player player = playerService.getPlayer();

        // then
        assertThat(player.getName()).isEqualTo("12345");
        assertThat(player.getMaxHp()).isEqualTo(20);
        assertThat(player.getMaxMp()).isEqualTo(180);
    }

    @Test
    @DisplayName("Player의 이름은 6자이고 HP, MP의 합이 200이 아닌 경우")
    void getPlayerTest4() {
        // given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        PlayerService playerService = new PlayerService(scanner, exceptionHandler);
        when(exceptionHandler.handleIllegalPlayerHpMpNameException(any(IllegalArgumentException.class), eq(playerService))).thenReturn(new Player(100, 100, "12345"));
        // when
        when(scanner.nextLine()).thenReturn("123456", "100,1020", "12345", "100,100");
        Player player = playerService.getPlayer();

        // then
        assertThat(player.getName()).isEqualTo("12345");
        assertThat(player.getMaxHp()).isEqualTo(100);
        assertThat(player.getMaxMp()).isEqualTo(100);
    }

    @Test
    @DisplayName("Player가 물리공격을 한다.")
    void doPhysicalAttackTest() {
        // given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        PlayerService playerService = new PlayerService(scanner, exceptionHandler);
        Player player = new Player(100, 100, "test");
        Boss boss = new Boss(150);

        // when
        AttackResult result = playerService.doPhysicalAttack(player, boss);
        Player playerAfterAttack = result.getPlayer();
        Boss bossAfterAttack = result.getBoss();

        // then
        assertThat(playerAfterAttack.getMaxHp()).isEqualTo(100);
        assertThat(playerAfterAttack.getMaxMp()).isEqualTo(100);
        assertThat(playerAfterAttack.getHp()).isEqualTo(100);
        assertThat(playerAfterAttack.getMp()).isEqualTo(100);
        assertThat(bossAfterAttack.getMaxHp()).isEqualTo(150);
        assertThat(bossAfterAttack.getHp()).isEqualTo(140);
    }

    @Test
    @DisplayName("Player가 마법공격을 한다.")
    void doMagicalAttackTest() {
        // given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        PlayerService playerService = new PlayerService(scanner, exceptionHandler);
        Player player = new Player(100, 100, "test");
        Boss boss = new Boss(150);

        // when
        AttackResult result = playerService.doMagicalAttack(player, boss);
        Player playerAfterAttack = result.getPlayer();
        Boss bossAfterAttack = result.getBoss();

        // then
        assertThat(playerAfterAttack.getMaxHp()).isEqualTo(100);
        assertThat(playerAfterAttack.getMaxMp()).isEqualTo(100);
        assertThat(playerAfterAttack.getHp()).isEqualTo(100);
        assertThat(playerAfterAttack.getMp()).isEqualTo(70);
        assertThat(bossAfterAttack.getMaxHp()).isEqualTo(150);
        assertThat(bossAfterAttack.getHp()).isEqualTo(130);
    }

    @Test
    @DisplayName("Player가 공격을 당한다.")
    void doAttackTest() {
        // given
        Player player = new Player(100, 100, "test");
        Boss boss = new Boss(150);

        // when
        Player result = PlayerService.getAttack(player);

        // then
        assertThat(result.getMaxHp()).isEqualTo(100);
        assertThat(result.getMaxMp()).isEqualTo(100);
        assertThat(result.getHp()).isBetween(80, 90);
        assertThat(result.getMp()).isEqualTo(100);
    }
}
