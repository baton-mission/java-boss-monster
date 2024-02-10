package bossmonster.view;

import bossmonster.domain.Game;

public class OutputView {

    private final OutputText outputText = new OutputText();
    private final static String startSentence = "보스 레이드를 시작합니다!";
    public void printInit(Game game) {
        System.out.println();
        System.out.println(startSentence);
        System.out.println(outputText.printBossHp(game.getBossMonster()));
        System.out.println(outputText.BOSS_INIT());
        System.out.println(outputText.printPlayerInfo(game.getPlayer()));
    }

    public void printPhysicalAttack(int random) {
        System.out.println(outputText.printPhysicalAttack(random));
    }

    public void printResult(Game game){
        System.out.println(outputText.printBossHp(game.getBossMonster()));
        System.out.println(outputText.BOSS_LOSING());
        System.out.println(outputText.printPlayerInfo(game.getPlayer()));
    }

    public void printMagicAttack(int random) {
        System.out.println(outputText.printMagicAttack(random));
    }
}
