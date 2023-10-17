package bossmonster.controller;

import bossmonster.domain.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.PlayerStatDto;

public class BossMonsterController {
    private final InputView inputView;
    private final OutputView outputView;

    public BossMonsterController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        BossMonster bossMonster = createBossMonster();
        Player player = createPlayer();
        while (!bossMonster.isDead() && !player.isDead()) {
            printGameStatus(player, bossMonster);
            BeginPlayerTurn(player, bossMonster);
            BeginBossMonsterTurn(player, bossMonster);
        }
        outputView.printGameResult(player, bossMonster);
    }

    private void printGameStatus(Player player, BossMonster bossMonster) {
        outputView.printGameStatus(player, bossMonster);
    }

    private BossMonster createBossMonster() {
        int bossMonsterHp = inputView.readBossMonsterHp();
        return new BossMonster(bossMonsterHp);
    }

    private Player createPlayer() {
        String playerName = inputView.readPlayerName();
        PlayerStatDto playerStatDto = inputView.readPlayerStat();
        int playerHp = playerStatDto.getHp();
        int playerMp = playerStatDto.getMp();
        return new Player(playerName, playerHp, playerMp);
    }

    private void BeginPlayerTurn(Player player, BossMonster bossMonster) {
        int type = inputView.readAttackType();
        AttackType attackType = AttackType.fromType(type);
        int beforeBossHp = bossMonster.getHp().getCurrentEnergy();
        player.attack(bossMonster, attackType);
        int afterBossHp = bossMonster.getHp().getCurrentEnergy();
        outputView.printPlayerAttack(beforeBossHp - afterBossHp, attackType);
    }

    private void BeginBossMonsterTurn(Player player, BossMonster bossMonster) {
        if (bossMonster.isDead()) {
            return;
        }
        int beforePlayerHp = player.getHp().getCurrentEnergy();
        bossMonster.attack(player);
        int afterPlayerHp = player.getHp().getCurrentEnergy();
        outputView.printBossAttack(beforePlayerHp - afterPlayerHp);
    }
}
