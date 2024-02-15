package bossmonster.Exception;

import bossmonster.Domain.Boss;
import bossmonster.Domain.Game;
import bossmonster.Domain.Player;
import bossmonster.Dto.AttackResult;
import bossmonster.Service.BossService;
import bossmonster.Service.GameService;
import bossmonster.Service.PlayerService;
import java.util.Scanner;

public class GlobalExceptionHandler implements ExceptionHandler {

    public Boss handleIllegalBossHpException(IllegalArgumentException e, BossService bossService) {
        this.handle(e);
        Boss boss = bossService.getBoss();
        return boss;
    }
    public Player handleIllegalPlayerHpMpNameException(IllegalArgumentException e, PlayerService playerService) {
        this.handle(e);
        Player player = playerService.getPlayer();
        return player;
    }
    public Player handleIllegalPlayerHpMpException(IllegalArgumentException e, PlayerService playerService, String name) {
        this.handle(e);
        Player player = playerService.getPlayerWithName(name);
        return player;
    }

    public Player handleIllegalPlayerNameException(IllegalArgumentException e, PlayerService playerService, int hp, int mp) {
        this.handle(e);
        Player player = playerService.getPlayerWithHpMp(hp, mp);
        return player;
    }

    public int handleIllegalAttackTypeException(IllegalArgumentException e, GameService gameService) {
        this.handle(e);
        return gameService.getAttackType();
    }

    public Game handleLowMpException(IllegalArgumentException e, PlayerService playerService, Game game) {
        this.handle(e);
        AttackResult result = playerService.doPhysicalAttack(game.getPlayer(), game.getBoss());
        game = new Game(game.getTurn(), result.getBoss(), result.getPlayer());
        return game;
    }

    @Override
    public void handle(final Exception e) {
        System.out.println(e.getMessage() + "\n");
    }
}