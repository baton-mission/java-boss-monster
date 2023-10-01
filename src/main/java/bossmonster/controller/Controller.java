package bossmonster.controller;

import java.util.List;
import java.util.Scanner;

import bossmonster.Attack;
import bossmonster.Hp;
import bossmonster.Mp;
import bossmonster.Name;
import bossmonster.RandomBossMonsterDamageGenerator;
import bossmonster.Stat;
import bossmonster.dto.BossMonsterInfo;
import bossmonster.dto.PlayerInfo;
import bossmonster.monster.BossMonster;
import bossmonster.monster.BossMonsterAppearance;
import bossmonster.player.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Controller {

    private final Scanner scanner;
    private final RandomBossMonsterDamageGenerator bossMonsterDamageGenerator;

    public Controller(Scanner scanner, RandomBossMonsterDamageGenerator bossMonsterDamageGenerator) {
        this.scanner = scanner;
        this.bossMonsterDamageGenerator = bossMonsterDamageGenerator;
    }

    public void start() {
        BossMonster bossMonster = generateBossMonster();
        Player player = generatePlayer();

        OutputView.printStartMessage();

        int numberOfTurns = 0;
        battle(bossMonster, player, numberOfTurns);
    }

    private void battle(BossMonster bossMonster, Player player, int numberOfTurns) {
        numberOfTurns++;

        // 보스 몬스터와 플레이어의 정보
        printInfo(bossMonster, player);

        // 플레이어 공격
        Attack playerAttack = Attack.of(InputView.readPlayerAttackNumber(scanner));
        player.attack(playerAttack, bossMonster);
        OutputView.printPlayerAttackResult(playerAttack.getName(), playerAttack.getDamage());

        if (bossMonster.isDead()) {
            OutputView.printWinningMessage(PlayerInfo.from(player), numberOfTurns);
            return;
        }

        // 보스 몬스터 공격
        int bossMonsterAttackDamage = bossMonsterDamageGenerator.generateDamage();
        bossMonster.attack(bossMonsterAttackDamage, player);
        OutputView.printBossMonsterAttackResult(bossMonsterAttackDamage);

        if (player.isDead()) {
            bossMonster.changeAppearance(BossMonsterAppearance.HAPPY);
            printInfo(bossMonster, player);
            OutputView.printDefeatMessage(PlayerInfo.from(player));
            return;
        }

        battle(bossMonster, player, numberOfTurns);
    }

    private void printInfo(BossMonster bossMonster, Player player) {
        OutputView.printBoldBoundary();
        OutputView.printBossMonsterInfo(BossMonsterInfo.from(bossMonster));
        OutputView.printPlayerInfo(PlayerInfo.from(player));
        OutputView.printBoldBoundary();
    }

    private BossMonster generateBossMonster() {
        Hp bossMonsterHp = new Hp(InputView.readBossMonsterHp(scanner));
        return new BossMonster(bossMonsterHp);
    }

    private Player generatePlayer() {
        String playerName = InputView.readPlayerName(scanner);
        List<Integer> playerInitialHpAndMp = InputView.readPlayerInitialHpAndMp(scanner);
        Hp playerHp = new Hp(playerInitialHpAndMp.get(0));
        Mp playerMp = new Mp(playerInitialHpAndMp.get(1));
        return new Player(new Name(playerName), new Stat(playerHp, playerMp));
    }
}
