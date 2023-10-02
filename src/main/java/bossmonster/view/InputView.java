package bossmonster.view;

import bossmonster.domain.AttackType;
import bossmonster.domain.Boss;
import bossmonster.util.ErrorChecker;
import bossmonster.util.TypeConvertor;

import java.util.Scanner;

import static bossmonster.util.Constants.*;

public class InputView {

    private final Scanner in;

    public InputView(Scanner in) {
        this.in = in;
    }

    public Boss getBossHP() {
        System.out.println(BOSS_HP_INPUT);
        try {
            String input = in.next();
            return new Boss(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBossHP();
        }
    }

    public String getPlayerName() {
        System.out.println(PLAYER_NAME_INPUT);
        try {
            String input = in.next();
            ErrorChecker.checkName(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerName();
        }
    }

    public int[] getPlayerStatus() {
        System.out.println(PLAYER_INFO_INPUT);
        try {
            String input = in.next();
            return TypeConvertor.convertStringToInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerStatus();
        }
    }

    public AttackType getAttackType() {
        System.out.println(ATTACK_INPUT);
        try {
            String command = in.next();
            return AttackType.findByCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAttackType();
        }
    }
}
