package bossmonster.view;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Game;
import bossmonster.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private final BossMonster bossMonster1 = new BossMonster(100);
    private final Player player1 = new Player("dori", 100, 100);
    private final Player player2 = new Player("pobi", 10, 190);
    private final Game game1 = new Game(bossMonster1, player1);
    private final Game game2 = new Game(bossMonster1, player2);
    private final static int RANDOM_NUMBER = 13;
    private  final OutputView outputView = new OutputView();

    @Test
    @DisplayName("초기 출력 테스트")
    void printInitTest(){
        System.out.println("테스트1");
        outputView.printInit(game1);
        System.out.println("\n테스트2");
        outputView.printInit(game2);
    }

    @Test
    @DisplayName("과정 결과 출력 테스트")
    void printProcessResult(){
        outputView.printResult(game1, false);
    }

    @Test
    @DisplayName("플레이어 죽었을 때의 결과 출력 테스트")
    void printResultPlayerDeadTest(){
        outputView.printResult(game1, true);
    }

    @Test
    @DisplayName("아이콘 출력 테스트")
    void printIconTest(){
        System.out.println("플레이어 죽었을 때");
        outputView.printIcon(true);

        System.out.println("\n플레이어 살았을 때");
        outputView.printIcon(false);
    }

    @Test
    @DisplayName("마법 공격 출력 테스트")
    void printMagicAttackTest(){
        System.out.println("보스 죽었을 때");
        outputView.printMagicAttack(RANDOM_NUMBER, true);

        System.out.println("\n보스 살았을 때");
        outputView.printMagicAttack(RANDOM_NUMBER, false);
    }

    @Test
    @DisplayName("물리 공격 출력 테스트")
    void printPhysicalAttackTest(){
        System.out.println("보스 죽었을 때");
        outputView.printPhysicalAttack(RANDOM_NUMBER, true);

        System.out.println("\n보스 살았을 때");
        outputView.printPhysicalAttack(RANDOM_NUMBER, false);
    }

    @Test
    @DisplayName("실패 메시지 출력 테스트")
    void printFailTest(){
        outputView.printFailMessage();
    }

    @Test
    @DisplayName("성공 메시지 출력 테스트")
    void printWinningTest(){
        outputView.printWinMessage(game1);
    }
}
