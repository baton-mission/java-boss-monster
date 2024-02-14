package bossmonster.Service;

import bossmonster.Controller.BossController;
import bossmonster.Domain.Boss;
import bossmonster.Exception.GlobalExceptionHandler;
import java.util.Scanner;

public class BossService {
    private final BossController bossController;
    private final Scanner scanner;
    private final GlobalExceptionHandler exceptionHandler;

    public BossService(Scanner scanner, GlobalExceptionHandler exceptionHandler){
        this.bossController = new BossController(scanner);
        this.scanner = scanner;
        this.exceptionHandler = exceptionHandler;
    }

    public Boss getBoss() {
        int hp = bossController.getBossHp();

        if (hp < 100 || hp > 300) {
            Boss fixedBoss = exceptionHandler.handleIllegalBossHpException(new IllegalArgumentException("[ERROR] 보스의 체력은 100 이상 300 이하여야 합니다."), this);
            return fixedBoss;
        }else {
            return new Boss(hp);
        }
    }
}
