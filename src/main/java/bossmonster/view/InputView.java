package bossmonster.view;

import java.util.Scanner;

import bossmonster.AttackType;
import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class InputView {
    private static Scanner scan = new Scanner(System.in);

    public int inputBossHp() {
        System.out.println("Enter boss monster's health : ");
        try {
            return BossMonster.validateBossHp(Integer.parseInt(scan.nextLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputBossHp();
        }
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
}
