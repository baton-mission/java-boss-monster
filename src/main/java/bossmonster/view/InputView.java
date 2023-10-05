package bossmonster.view;

import java.util.Scanner;

import bossmonster.AttackType;
import bossmonster.domain.Player;

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
            return Player.validateName(scan.next().trim());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayerName();
        }
    }

    public int[] inputHpMp() { //////// [hp mp] uh ke um gi noh...
        System.out.println("Enter Players HP and MP : ");
        try {
            return Player.validatesumOfHpMp(scan.nextInt(), scan.nextInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputHpMp();
        }
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
            throw new IllegalArgumentException("[Error] : 보스 몬스터의 체력은 100에서 300사이 여야합니다.");
        }
        return true;
    }
}
