package bossmonster.action;

import bossmonster.error.Error;

// 게임
public class Play extends InitialCharacter {
    private final BossMonsterAction bossMonsterAction = new BossMonsterAction();
    private final PlayerAction playerAction = new PlayerAction();

    private int totalTurn = 0;

    public Play() {
        super();
        bossMonsterAction.setBossMoster(getBossMoster());
        playerAction.setPlayer(getPlayer());
    }

    public void start() {
        // 첫 시작

        while (!bossMonsterAction.checkHP() && !playerAction.checkHP()) {
            // 상태 출력
            if (getBossMoster().getHP() == getBossMoster().getCurrentHP()) bossMonsterAction.printFirstState();
            else bossMonsterAction.printAttackedState();
            playerAction.printState();

            // 플레이어 공격
            boolean check = true;
            while(check) { // MP 확인
                // 플레이어 - 공격 방법 입력받기
                int attack = printAttack();

                // 플레이어 - 공격
                check = playerAttack(attack);
            }

            // 보스 몬스터 - 공격
            playerAction.damage(bossMonsterAction.attack());
            totalTurn++;
        }

        // 종료
        if (bossMonsterAction.checkHP()) { // 승리
            bossMonsterAction.printAttackedState();
            playerAction.printState();
            System.out.println(getPlayer().getName() + " 님이 " + totalTurn + "번의 전투 끝에 보스 몬스터를 잡았습니다.");
        }
        if (playerAction.checkHP()) { // 패배
            bossMonsterAction.printWinState();
            playerAction.printState();
            System.out.println(getPlayer().getName() + "의 HP가 0이 되었습니다.");
            System.out.println("보스 레이드에 실패했습니다.");
        }
    }

    // 플레이어 공격
    private boolean playerAttack(int attack) {
        boolean check = true; // 공격 성공한 경우
        if (attack == 1) { // 물리공격
            playerAction.physicalAttack();
            bossMonsterAction.damage(10);
            check = false;
        } else if (attack == 2 & !playerAction.magicAttack()) { // 마법공격
            bossMonsterAction.damage(20);
            check = false;
        }

        return check;
    }

    // 공격 멘트 출력
    private int printAttack() {
        System.out.println("어떤 공격을 하시겠습니까?\n" +
                "1. 물리 공격\n" +
                "2. 마법 공격");

        int attack = sc.nextInt();

        while (attack != 1 && attack != 2) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Error.printError("공격하셔야 합니다. 1 또는 2를 입력해주세요.");
            }

            attack = sc.nextInt();
        }

        return attack;
    }
}
