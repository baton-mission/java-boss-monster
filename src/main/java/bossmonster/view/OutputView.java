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

    public void printPhysicalAttack(int random, boolean bossDie) {
        System.out.println(outputText.printPhysicalAttack(random, bossDie));
    }

    public void printResult(Game game, boolean playerDie){
        System.out.println(outputText.printBossHp(game.getBossMonster()));
        printIcon(playerDie);
        System.out.println(outputText.printPlayerInfo(game.getPlayer()));
    }

    public void printIcon(boolean playerDie){
        if(playerDie){
            System.out.println(outputText.BOSS_WINNING());
            return;
        }
        System.out.println(outputText.BOSS_LOSING());
    }

    public void printMagicAttack(int random, boolean bossDie) {
        System.out.println(outputText.printMagicAttack(random, bossDie));
    }

    public void printFailMessage(){
        System.out.println(outputText.printFailMessage());
    }

    public void printWinMessage(Game game){
        System.out.println(outputText.printWinMessage(game.getPlayer(), game.getNumberOfTimes()));
    }
}
