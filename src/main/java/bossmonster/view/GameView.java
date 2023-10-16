package bossmonster.view;


import bossmonster.domain.monster.Monster;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.PlayerHp;
import bossmonster.domain.player.PlayerMp;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStats;
import bossmonster.domain.player.Skill;

// todo print가 많긴함 나누면 좋을까?
public class GameView {

    public static final String LINE_BREAK = "\n";
    private Input input;
    private Output output;

    public GameView(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    // TODO while이 어디에 들어가면 좋을지 생각해보기 , 유효성검사 어디에 있는게 좋을지
    public int askBossMonsterHP() {
        output.printLine("보스 몬스터의 HP를 입력해주세요.");
        return input.enterNumber();
    }

    public String askPlayerName() {
        output.printLine("플레이어의 이름을 입력해주세요");
        return input.enterText();
    }

    public String askPlayerHPAndMP() {
        output.printLine("플레이어의 HP와 MP를 입력해주세요.(, 로 구분)");
        return input.enterText();
    }

    public void printStartGame(Player player, Monster monster) {
        printStart();
        printEqualsLine();
        printMonsterHP(monster);
        printUnderScoreLine();
        printStartCharacter();
        printUnderScoreLine();
        enter();
        printPlayerHPAndMP(player);
        printEqualsLine();
        enter();
    }

    public void printPlayerAndMonsterInformation(Player player, Monster monster) {
        printEqualsLine();
        printMonsterHP(monster);
        printUnderScoreLine();
        printProgressCharacter();
        printUnderScoreLine();
        enter();
        printPlayerHPAndMP(player);
        printEqualsLine();
        enter();
    }

    public void enter() {
        output.print(LINE_BREAK);
    }

    private void printStart() {
        enter();
        output.printLine("보스 레이드를 시작합니다!");
        enter();
    }

    private void printEqualsLine() {
        output.printLine("============================");
    }

    private void printUnderScoreLine() {
        output.printLine("____________________________");
    }

    private void printMonsterHP(Monster monster) {
        output.printLine("BOSS HP [" + monster.getCurrentHp() + "/" + monster.getMaxHp() + "]");
    }

    private void printPlayerHPAndMP(Player player) {
        PlayerName name = player.getName();
        PlayerStats playerStats = player.getPlayerStats();
        PlayerHp playerHp = playerStats.getPlayerHp();
        PlayerMp playerMp = playerStats.getPlayerMp();
        output.printLine(
                name.getName() + " HP [" + playerHp.getCurrentHp() + "/" + playerHp.getMaxHp()
                        + "] MP [" + playerMp.getCurrentMp() + "/" + playerMp.getMaxMp() + "]");
    }

    private void printStartCharacter() {
        output.printLine(createMonsterCharacterWithZeroZeroEyes());
    }

    private void printProgressCharacter() {
        output.printLine(createMonsterCharacterWithXXEyes());
    }

    private String createMonsterCharacterWithZeroZeroEyes() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ^-^").append(LINE_BREAK);
        stringBuilder.append(" / 0 0 \\").append(LINE_BREAK);
        stringBuilder.append("(   \"   )").append(LINE_BREAK);
        stringBuilder.append(" \\  -  /").append(LINE_BREAK);
        stringBuilder.append("  - ^ -");

        return stringBuilder.toString();

    }

    private String createMonsterCharacterWithXXEyes() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ^-^").append(LINE_BREAK);
        stringBuilder.append(" / x x \\").append(LINE_BREAK);
        stringBuilder.append("(   \"   )").append(LINE_BREAK);
        stringBuilder.append(" \\  -  /").append(LINE_BREAK);
        stringBuilder.append("  - ^ -");

        return stringBuilder.toString();

    }

    public String askSkillNo() {
        printSkillList();
        return input.enterText();

    }

    private void printSkillList() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("어떤 공격을 하시겠습니까?").append(LINE_BREAK)
                .append("1. 물리 공격").append(LINE_BREAK)
                .append("2. 마법 공격");
        output.printLine(stringBuilder.toString());
    }

    public void printPlayerAttack(Skill skill) {
        String message = getPlayerAttackMessage(skill);
        output.printLine(message);
    }

    private String getPlayerAttackMessage(Skill skill) {
        enter();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(skill.getSkillName()).append("을 했습니다. ")
                .append("(입힌 데미지: ").append(skill.getDamage()).append(")");
        return stringBuilder.toString();
    }


    public void printMonsterAttack(int damage) {
        output.printLine("보스가 공격 했습니다. (입힌 데미지:" + damage + ")");
    }

    public void printWin(Player player, int matchCount) {
        enter();
        output.printLine(player.getName().getName() + " 님이 " + matchCount + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
    }

    public void printLose(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(player.getName().getName() + "의 HP가 0이 되었습니다.").append(LINE_BREAK)
                .append("보스 레이드에 실패했습니다.");
        output.printLine(stringBuilder.toString());
    }

    public void printErrorMessage(Exception e) {
        output.printLine(e.getMessage());
    }


}
