package bossmonster.Service;

import bossmonster.Controller.PlayerController;
import bossmonster.Domain.Player;
import bossmonster.Exception.ExceptionHandler;
import bossmonster.Exception.GlobalExceptionHandler;
import java.util.Scanner;

public class PlayerService {
    private final Scanner scanner;
    private final GlobalExceptionHandler exceptionHandler;
    private final PlayerController playerController;

    public PlayerService(Scanner scanner, GlobalExceptionHandler exceptionHandler) {
        this.scanner = scanner;
        this.exceptionHandler = exceptionHandler;
        this.playerController = new PlayerController(scanner);
    }

    public Player getPlayer() {
        String name = playerController.getPlayerName();
        int[] hpMp = playerController.getPlayerHpMp();
        int hp = hpMp[0];
        int mp = hpMp[1];

        Player fixedPlayer;

        if (hp + mp != 200 && name.length() <= 5) {
            fixedPlayer = exceptionHandler.handleIllegalPlayerHpMpException(
                    new IllegalArgumentException("[ERROR] 플레이어의 HP와 MP의 합은 200이여야 합니다."), this, name);
        }else if (hp + mp != 200) {
            fixedPlayer = exceptionHandler.handleIllegalPlayerHpMpNameException(
                    new IllegalArgumentException("[ERROR] 플레이어의 HP와 MP의 합은 200이여야 하고 이름은 5자 이하이여햐 합니다."), this);
        }else if (name.length() > 5) {
            fixedPlayer = exceptionHandler.handleIllegalPlayerNameException(
                    new IllegalArgumentException("[ERROR] 플레이어의 이름은 5자 이하여야 합니다."), this, hp, mp);
        }else {
            return new Player(hp, mp, name);
        }
        return fixedPlayer;
    }

    public Player getPlayerWithName(final String name) {
        int[] hpMp = playerController.getPlayerHpMp();
        int hp = hpMp[0];
        int mp = hpMp[1];

        Player fixedPlayer;
        if (hp + mp != 200) {
            fixedPlayer = exceptionHandler.handleIllegalPlayerHpMpException(
                    new IllegalArgumentException("[ERROR] 플레이어의 HP와 MP의 합은 200이여야 합니다."), this, name);
        }else {
            return new Player(hp, mp, name);
        }
        return fixedPlayer;
    }

    public Player getPlayerWithHpMp(final int hp, final int mp) {
        String name = playerController.getPlayerName();

        Player fixedPlayer;
        if (hp + mp != 200) {
            fixedPlayer = exceptionHandler.handleIllegalPlayerHpMpException(
                    new IllegalArgumentException("[ERROR] 플레이어의 HP와 MP의 합은 200이여야 합니다."), this, name);
        }else {
            return new Player(hp, mp, name);
        }
        return fixedPlayer;
    }
}
