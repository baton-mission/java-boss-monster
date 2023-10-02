package bossmonster.controller;

import java.util.List;
import java.util.Scanner;

import bossmonster.Attack;
import bossmonster.Hp;
import bossmonster.Mp;
import bossmonster.Name;
import bossmonster.RandomBossMonsterDamageGenerator;
import bossmonster.Service;
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
    private final Service service;

    public Controller(Scanner scanner, RandomBossMonsterDamageGenerator bossMonsterDamageGenerator, Service service) {
        this.scanner = scanner;
        this.bossMonsterDamageGenerator = bossMonsterDamageGenerator;
        this.service = service;
    }

    public void start() {
        BossMonster bossMonster = getBossMonster();
        Player player = getPlayer();
        OutputView.printStartMessage();
        int numberOfTurns = 0;
        battle(bossMonster, player, numberOfTurns);
    }

    private BossMonster getBossMonster() {
        return service.generateBossMonster(InputView.readBossMonsterHp(scanner));
    }

    private Player getPlayer() {
        String playerName = InputView.readPlayerName(scanner);
        List<Integer> playerInitialHpAndMp = InputView.readPlayerInitialHpAndMp(scanner);
        return service.generatePlayer(playerName, playerInitialHpAndMp);
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
}
