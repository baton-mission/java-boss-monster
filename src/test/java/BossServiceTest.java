import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import bossmonster.Domain.Boss;
import bossmonster.Exception.GlobalExceptionHandler;
import bossmonster.Service.BossService;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;

public class BossServiceTest {
    @Test
    @DisplayName("Boss의 HP를 검증한다(정상 범위)")
    void BossHpValidationTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        BossService bossService = new BossService(scanner, exceptionHandler);

        // When
        when(scanner.nextInt()).thenReturn(150);
        Boss boss = bossService.getBoss();
        int result = boss.getHp();

        // Then
        try {
            verify(exceptionHandler).handleIllegalBossHpException(any(IllegalArgumentException.class),bossService);
            fail("IllegalBossHpException이 발생하면 안됩니다.");
        } catch (Exception e) {
            assertThat(result).isEqualTo(150);
        }
    }

    @Test
    @DisplayName("Boss의 HP를 검증한다(비정상 범위 1회 이후 정상 범위 1회)")
    void BossHpValidationTest2() {
        // Given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        BossService bossService = new BossService(scanner, exceptionHandler);
        when(exceptionHandler.handleIllegalBossHpException(any(IllegalArgumentException.class), eq(bossService))).thenReturn(new Boss(150));

        // When
        when(scanner.nextInt()).thenReturn(500).thenReturn(150);
        Boss boss = bossService.getBoss();
        int result = boss.getHp();

        // Then
        verify(exceptionHandler).handleIllegalBossHpException(any(IllegalArgumentException.class), eq(bossService));
        assertThat(result).isEqualTo(150);
    }

    @Test
    @DisplayName("Boss가 물리 공격을 받는다")
    void BossPhysicalAttackTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        BossService bossService = new BossService(scanner, exceptionHandler);
        Boss boss = new Boss(150);

        // When
        Boss result = bossService.getPhysicalAttack(boss);

        // Then
        assertThat(result.getHp()).isEqualTo(140);
    }

    @Test
    @DisplayName("Boss가 마법 공격을 받는다")
    void BossMagicalAttackTest() {
        // Given
        Scanner scanner = mock(Scanner.class);
        GlobalExceptionHandler exceptionHandler = mock(GlobalExceptionHandler.class);
        BossService bossService = new BossService(scanner, exceptionHandler);
        Boss boss = new Boss(150);

        // When
        Boss result = bossService.getMagicalAttack(boss);

        // Then
        assertThat(result.getHp()).isEqualTo(130);
    }
}
