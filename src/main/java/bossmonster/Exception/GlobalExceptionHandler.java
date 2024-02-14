package bossmonster.Exception;

import bossmonster.Domain.Boss;
import bossmonster.Service.BossService;
import java.util.Scanner;

public class GlobalExceptionHandler implements ExceptionHandler {

    public Boss handleIllegalBossHpException(IllegalArgumentException e, BossService bossService) {
        this.handle(e);
        Boss boss = bossService.getBoss();
        return boss;
    }

    @Override
    public void handle(final Exception e) {
        System.out.println(e.getMessage());
    }
}