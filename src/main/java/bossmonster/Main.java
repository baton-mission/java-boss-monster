package bossmonster;

import bossmonster.Domain.Boss;
import bossmonster.Exception.GlobalExceptionHandler;
import bossmonster.Service.BossService;
import bossmonster.Service.GameService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService(new Scanner(System.in), new GlobalExceptionHandler());
        gameService.run();
    }
}
