package bossmonster.view;

import bossmonster.domain.*;
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

    public Name getPlayerName() {
        System.out.println(PLAYER_NAME_INPUT);
        try {
            String input = in.next();
            return new Name(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerName();
        }
    }

    public Status getPlayerStatus() {
        System.out.println(PLAYER_INFO_INPUT);
        try {
            String input = in.next();
            int[] amount = TypeConvertor.convertStringToInt(input);
            return new Status(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerStatus();
        }
    }

    public AttackType getAttackType(Player player) {
        System.out.println(ATTACK_INPUT);
        try {
            String command = in.next();
            AttackType attackType = AttackType.findByCommand(command);
            ErrorChecker.checkMana(player.getStatus(), attackType.getManaCost());
            return attackType;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getAttackType(player);
        }
    }
}
