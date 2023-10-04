package bossmonster.controller;

import java.util.List;
import java.util.function.Supplier;

import bossmonster.domain.player.Attack;
import bossmonster.domain.monster.BossMonsterDamageGenerator;
import bossmonster.service.Service;
import bossmonster.dto.BossMonsterInfo;
import bossmonster.dto.PlayerInfo;
import bossmonster.domain.monster.BossMonster;
import bossmonster.domain.player.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Controller {

    private final BossMonsterDamageGenerator bossMonsterDamageGenerator;
    private final Service service;

    public Controller(BossMonsterDamageGenerator bossMonsterDamageGenerator, Service service) {
        this.bossMonsterDamageGenerator = bossMonsterDamageGenerator;
        this.service = service;
    }

    public void start() {
        BossMonster bossMonster = repeatReadForInvalid(this::getBossMonster);
        Player player = repeatReadForInvalid(this::getPlayer);
        OutputView.printStartMessage();
        int numberOfTurns = 0;
        battle(bossMonster, player, numberOfTurns);
    }

    private BossMonster getBossMonster() {
        int bossMonsterHp = InputView.readBossMonsterHp();
        return service.generateBossMonster(bossMonsterHp);
    }

    private Player getPlayer() {
        String playerName = InputView.readPlayerName();
        List<Integer> playerInitialHpAndMp = InputView.readPlayerInitialHpAndMp();
        return service.generatePlayer(playerName, playerInitialHpAndMp);
    }

    private void battle(BossMonster bossMonster, Player player, int numberOfTurns) {
        numberOfTurns++;

        printInfo(bossMonster, player);
        playerAttack(bossMonster, player);
        if (bossMonster.isDead()) {
            OutputView.printWinningMessage(PlayerInfo.from(player), numberOfTurns);
            return;
        }

        bossMonsterAttack(bossMonster, player);
        if (player.isDead()) {
            service.changeBossMonsterAppearanceToHappy(bossMonster);
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

    private void playerAttack(BossMonster bossMonster, Player player) {
        Attack playerAttack = repeatReadForInvalid(() -> Attack.of(InputView.readPlayerAttackNumber()));
        try {
            service.playerAttack(playerAttack, player, bossMonster);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            playerAttack(bossMonster, player);
        }
        OutputView.printPlayerAttackResult(playerAttack.getName(), playerAttack.getDamage());
    }

    private void bossMonsterAttack(BossMonster bossMonster, Player player) {
        int bossMonsterAttackDamage = bossMonsterDamageGenerator.generateDamage();
        service.bossMonsterAttack(bossMonsterAttackDamage, bossMonster, player);
        OutputView.printBossMonsterAttackResult(bossMonsterAttackDamage);
    }

    private <T> T repeatReadForInvalid(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return repeatReadForInvalid(reader);
        }
    }
}
