package bossmonster.view;

import bossmonster.domain.game.GameStatus;
import bossmonster.domain.monster.Monster;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.PlayerHp;
import bossmonster.domain.player.PlayerMp;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStats;
import bossmonster.domain.player.Skill;
import bossmonster.message.OutputMessage;

public class OutputView {

    public void printMonsterInfo(Monster monster) {
        printEmptyLine();
        printEqualsLine();
        printMonsterHP(monster);
        printEmptyLine();
        printUnderScoreLine();
    }

    public void printPlayerInfo(Player player) {
        printUnderScoreLine();
        printEmptyLine();
        printPlayerHPAndMP(player);
        printEmptyLine();
        printEqualsLine();
        printEmptyLine();
    }
    public void printMonsterCharacter(GameStatus gameStatus) {
        System.out.println(gameStatus.getCharacter());
    }

    public void printStart() {
        printEmptyLine();
        System.out.println(OutputMessage.START_GAME.getMessage());
    }

    private void printEqualsLine() {
        System.out.println(OutputMessage.EQUALS_LINE.getMessage());
    }

    private void printUnderScoreLine() {
        System.out.println(OutputMessage.UNDERSCORE_LINE.getMessage());
    }

    private void printMonsterHP(Monster monster) {
        System.out.printf(OutputMessage.MONSTER_HP.getMessage(), monster.getCurrentHp(),
                monster.getMaxHp());
    }

    private void printPlayerHPAndMP(Player player) {
        PlayerName name = player.getName();
        PlayerStats playerStats = player.getPlayerStats();
        PlayerHp playerHp = playerStats.getPlayerHp();
        PlayerMp playerMp = playerStats.getPlayerMp();
        System.out.printf(OutputMessage.PLAYER_HP_AND_MP.getMessage(),
                name.getName(), playerHp.getCurrentHp(), playerHp.getMaxHp(),
                playerMp.getCurrentMp(), playerMp.getMaxMp()
        );
    }

    public void printPlayerAttack(Skill skill) {
        printEmptyLine();
        System.out.printf(OutputMessage.PLAYER_ATTACK.getMessage(), skill.getSkillName(),
                skill.getDamage());
        printEmptyLine();
    }

    public void printMonsterAttack(int damage) {
        System.out.printf(OutputMessage.MONSTER_ATTACK.getMessage(), damage);
        printEmptyLine();
    }

    public void printWin(Player player, int matchCount) {
        printEmptyLine();
        System.out.printf(OutputMessage.GAME_WIN.getMessage(), player.getName().getName(),
                matchCount);
    }

    public void printLose(Player player) {
        System.out.printf(OutputMessage.GAME_LOSE.getMessage(), player.getName().getName());
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private void printEmptyLine() {
        System.out.println();
    }


}
