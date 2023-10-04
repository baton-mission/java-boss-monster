package bossmonster;

import java.util.Scanner;

import bossmonster.controller.Controller;
import bossmonster.domain.monster.BossMonsterDamageGenerator;
import bossmonster.service.Service;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new BossMonsterDamageGenerator(),
                new Service()
        );
        controller.start();
    }
}
