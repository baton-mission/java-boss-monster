package message;

import domain.Boss;
import domain.Player;

public class PrintMessage {
    private static final Boss boss = Boss.getInstance();
    private static final Player player = Player.getInstance();

    public void printState(){
        System.out.println("============================");
        printBossState();
        printBossFace(boss.getState());
        printPlayerState();
        System.out.println("============================");
    }

    private void printBossState(){
        System.out.printf("BOSS HP [%d/%d]\n", boss.getCurrent_hp(), boss.getMax_hp());
    }

    private void printBossFace(int boss_state){
        System.out.println("____________________________");
        switch (boss_state) {
            case 1: {
                System.out.println("   ^-^");
                System.out.println(" / 0 0 \\");
                System.out.println("(   \"   )");
                System.out.println(" \\  -  /");
                System.out.println("  - ^ -");
                break;
            }
            case 2: {
                System.out.println("   ^-^");
                System.out.println(" / x x \\");
                System.out.println("(   \"\\  )");
                System.out.println(" \\  ^  /");
                System.out.println("  - ^ -");
                break;
            }
            case 3: {
                System.out.println("   ^-^");
                System.out.println(" / ^ ^ \\");
                System.out.println("(   \"   )");
                System.out.println(" \\  3  /");
                System.out.println("  - ^ -");
                break;
            }
        }
        System.out.println("____________________________\n");

    }

    private void printPlayerState(){
        System.out.printf("%s HP [%d/%d] MP [%d/%d] \n", player.getName(),
                player.getCurrent_hp(), player.getMax_hp(),
                player.getCurrent_mp(), player.getMax_mp());
    }

    public void printResult(boolean boss_lose, boolean player_lose, int count){
        if(boss_lose){
            System.out.printf("%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.", player.getName(), count);
        }

        if(player_lose){
            System.out.printf("%s의 HP가 0이 되었습니다. \n", player.getName());
            System.out.print("보스 레이드에 실패했습니다.");
        }
    }
}
