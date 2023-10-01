package bossmonster;

import java.util.Scanner;

import bossmonster.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new Scanner(System.in),
                new RandomBossMonsterDamageGenerator());
        controller.start();
    }
}
