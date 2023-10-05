package bossmonster.view;

import java.util.Scanner;

import bossmonster.AttackType;
import bossmonster.domain.Player;
import bossmonster.dto.PlayerHpMpParam;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);

    public int inputBossHp() {
        System.out.println("Enter boss monster's health : ");
        try {
            int userInput = Integer.parseInt(scan.nextLine());
            if (validateBossHp(userInput)) {
                return userInput;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputBossHp();
    }

    public String inputPlayerName() {
        System.out.println("Enter Player's name : ");
        try {
            String userInput = scan.next().trim();
            if(validatePlayerName(userInput)) {
                return userInput;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputPlayerName();
    }

    public PlayerHpMpParam inputHpMp() { //////// [hp mp] uh ke um gi noh...
        System.out.println("Enter Players HP and MP : ");
        try {
            PlayerHpMpParam playerHpMpParam = new PlayerHpMpParam(scan.nextInt(), scan.nextInt());
            if(validatePlayerHpMp(playerHpMpParam)) {
                return playerHpMpParam;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputHpMp();
    }

    public AttackType inputAttackType() {
        System.out.println("1 : Physical Attack    2 : Magical Attack");
        try {
            return AttackType.validateTypeNum(scan.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputAttackType();
        }
    }

    private boolean validateBossHp(int hp) throws IllegalArgumentException{
        if(hp > InputValidationConstant.BOSS_MAX_HP || hp < InputValidationConstant.BOSS_MIN_HP) {
            throw new IllegalArgumentException("[Error] 보스 몬스터의 체력은 100에서 300사이여야합니다.");
        }
        return true;
    }

    private boolean validatePlayerName(String name) throws IllegalArgumentException{
        if (name.length() > InputValidationConstant.MAX_PLAYER_NAME_SIZE) {
            throw new IllegalArgumentException(
                    "[Error] 이름의 최대 길이는 5글자 입니다.");
        }
        return true;
    }

    private boolean validatePlayerHpMp(PlayerHpMpParam playerHpMpParam) throws IllegalArgumentException{
        if(playerHpMpParam.getHp() + playerHpMpParam.getMp() > InputValidationConstant.SUM_OF_PLAYER_HP_MP) {
            throw new IllegalArgumentException("[Error] Hp와 Mp의 합은 200이여야합니다.");
        }
        return true;
    }
}
